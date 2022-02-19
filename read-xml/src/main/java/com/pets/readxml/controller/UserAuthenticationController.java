package com.pets.readxml.controller;

import com.pets.readxml.dto.CredentialDTO;
import com.pets.readxml.dto.TokenDTO;
import com.pets.readxml.dto.UserAuthenticationRequestDTO;
import com.pets.readxml.dto.UserAuthenticationResponseDTO;
import com.pets.readxml.entity.UserAuthentication;
import com.pets.readxml.secutiry.jwt.JwtService;
import com.pets.readxml.service.UserAuthenticationService;
import io.jsonwebtoken.Jwt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/users")
@Api(tags = "User")
public class UserAuthenticationController {
    @Autowired
    private UserAuthenticationService userService;

    @Autowired
    JwtService jwtService;

    @ApiOperation(value = "SalvarUsuario", nickname = "salvar-usuario")
    @PostMapping
    public ResponseEntity<UserAuthenticationResponseDTO> salvarUsuario(@RequestBody UserAuthenticationRequestDTO user){
        UserAuthentication usarioSalvar = userService.salvarUsuario(user.converterParaEntidade());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserAuthenticationResponseDTO.converterParaDTO(usarioSalvar));
    }

    @ApiOperation(value = "AutenticarUsuario")
    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredentialDTO credenciais){
        try {
            UserAuthentication user = new UserAuthentication(credenciais.getLogin(), credenciais.getPassword());
            UserDetails autenticatedUser = userService.autenticar(user);

            String token = jwtService.gerarToken(user);
            return new TokenDTO(user.getLogin(), token);

        } catch (UsernameNotFoundException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

    }

}
