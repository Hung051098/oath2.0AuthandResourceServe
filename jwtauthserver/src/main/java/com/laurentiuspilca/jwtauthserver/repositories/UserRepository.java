package com.laurentiuspilca.jwtauthserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurentiuspilca.jwtauthserver.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);

}
