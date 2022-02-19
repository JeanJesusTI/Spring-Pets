package com.pets.readxml.service;

import com.pets.readxml.entity.UserAuthentication;
import com.pets.readxml.exception.RegraNegocioException;
import com.pets.readxml.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    UserAuthenticationRepository userAuthenticationRepository;

    // Método para codificar senha
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserAuthentication salvarUsuario(UserAuthentication user){
        //Encripitando senha antes de salvar

        Optional<UserAuthentication> usuarioEncontrado = userAuthenticationRepository
                .findByLogin(user.getLogin());

        if(usuarioEncontrado.isPresent()){
            throw  new RegraNegocioException("Login já existente!");
        }

        String passwordToEncrypt = user.getPassword();
        user.setPassword(passwordEncoder().encode(passwordToEncrypt));
        return userAuthenticationRepository.save(user);
    }

    public UserDetails autenticar(UserAuthentication user){
        UserDetails usuario = loadUserByUsername(user.getLogin());

        boolean passwordMatches = passwordEncoder().matches(user.getPassword(), usuario.getPassword()); // validando pass

        if(passwordMatches){
            return usuario;
        }
        throw new RegraNegocioException("Dados Inválidos");

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthentication usuarioEncontrado = userAuthenticationRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String [] roles = usuarioEncontrado.getAdmin().equals(true) ?
                new String[] {"ADMIN", "USER"} : new String[] {"USER"};

        return User
                .builder()
                .username(usuarioEncontrado.getLogin())
                .password(usuarioEncontrado.getPassword())
                .roles(roles)
                .build();
    }
}
