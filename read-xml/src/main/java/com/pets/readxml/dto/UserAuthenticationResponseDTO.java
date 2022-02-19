package com.pets.readxml.dto;

import com.pets.readxml.entity.UserAuthentication;
import org.springframework.beans.factory.annotation.Value;

public class UserAuthenticationResponseDTO {
    private String login;

    @Value("${password.message.private}")
    private String password;

    public UserAuthenticationResponseDTO() {
    }

    public UserAuthenticationResponseDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public static UserAuthenticationResponseDTO converterParaDTO(UserAuthentication user){
        UserAuthenticationResponseDTO userAuthenticationResponseDTO =
                new UserAuthenticationResponseDTO(user.getLogin(), user.getPassword());
        userAuthenticationResponseDTO.setPassword("*CONFIDENTIAL*");
        return userAuthenticationResponseDTO;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
