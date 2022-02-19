package com.pets.readxml.secutiry.jwt;

import com.pets.readxml.ReadXmlApplication;
import com.pets.readxml.entity.UserAuthentication;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${secutiry.jwt.expiration}")
    private String expiration_minute;

    @Value("${secutiry.jwt.signature}")
    private String signature_key;

    // Método para geração de Token
    public String gerarToken(UserAuthentication user){
        Long expirationTime = Long.valueOf(expiration_minute);

        // Adicionando tempo de expiração do Token apartir da data e hora atual
        // Por padrão, o token terá o tempo de expiração de 30 minutos
        LocalDateTime dateTimeExpiration = LocalDateTime.now().plusMinutes(expirationTime);

        // Deve-se converter a data e hora para Date (Pois é o que o JWTs requer)
        Instant instant = dateTimeExpiration.atZone(ZoneId.systemDefault()).toInstant();

        // Convertendo instant gerado para Data
        Date data = Date.from(instant);

        // Retornando Token
        return Jwts
                .builder()
                .setSubject(user.getLogin()) // identificador do usuário será o nome de login
                .setExpiration(data) // configurando tempo de expiração
                .signWith(SignatureAlgorithm.HS512, signature_key) // Escolhendo algoritimo e passando chave como parametro
                .compact(); // compactando todas as informções


    }

    public Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser() // Responsável por decodificar o token para obter as Claims
                .setSigningKey(signature_key) // Chave que encodificou o token
                .parseClaimsJws(token) // Passando token onde está as Caims
                .getBody(); // Retornando as claims encontradas
    }

    public Boolean verificarSeTokenEValido(String token){
        try {
            Claims claims = obterClaims(token); // Caso o Token seja inválido, será retornado uma Exception por default
            Date expirationDate = claims.getExpiration();
            LocalDateTime data = expirationDate.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        }catch (Exception e){
            return false;
        }
    }

    // Metodo para retornar o Login do usuário
    public String obterLoginUsuario(String token){
        return (String) obterClaims(token).getSubject();
    }

    // Testando aplicação
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReadXmlApplication.class);
        JwtService service = context.getBean(JwtService.class);
        UserAuthentication usuario = new UserAuthentication("userAdmin", "123", true);
        String token = service.gerarToken(usuario);

        System.out.println(token);
        boolean isTokenValid = service.verificarSeTokenEValido(token);
        System.out.println(service.obterLoginUsuario(token));
        System.out.println("TOKEN VALIDO? "+isTokenValid);

    }

}
