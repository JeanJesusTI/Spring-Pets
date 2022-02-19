package com.pets.readxml.repository;

import com.pets.readxml.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Integer> {
    Optional<UserAuthentication> findByLogin(String login);
}
