package com.pets.readxml.dto;

import com.pets.readxml.entity.UserAuthentication;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;

public class UserAuthenticationRequestDTO {

    @ApiModelProperty(name = "login")
    private String login;

    @ApiModelProperty(name = "password")
    private String password;

    @ApiModelProperty(name = "admin")
    private Boolean admin;

    public UserAuthentication converterParaEntidade(){
        return new UserAuthentication(login, password, admin);
    }

    public String getLogin() {
        return login;
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
