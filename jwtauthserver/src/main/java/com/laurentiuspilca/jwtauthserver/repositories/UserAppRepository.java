package com.laurentiuspilca.jwtauthserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laurentiuspilca.jwtauthserver.entities.User;
import com.laurentiuspilca.jwtauthserver.entities.UserApp;

public interface UserAppRepository extends JpaRepository<UserApp, Integer>{

	@Query(nativeQuery = true, value = "select * from user_app where username=?1")
	UserApp findByUsernameApp(String username);
	
	Optional<UserApp> findByUsername(String username);

}
