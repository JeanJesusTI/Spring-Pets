package com.pets.readxml.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private Boolean admin;

    public UserAuthentication() {
    }

    public UserAuthentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserAuthentication(String login, String password, Boolean admin) {
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public UserAuthentication(Integer id, String login, String password, Boolean admin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthentication)) return false;
        UserAuthentication that = (UserAuthentication) o;
        return id.equals(that.id) && login.equals(that.login) && password.equals(that.password) && admin.equals(that.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, admin);
    }
}
