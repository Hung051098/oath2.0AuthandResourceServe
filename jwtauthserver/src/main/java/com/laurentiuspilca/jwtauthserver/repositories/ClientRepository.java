package com.laurentiuspilca.jwtauthserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laurentiuspilca.jwtauthserver.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Query(value = "select * from client c where clientid = ?1", nativeQuery = true)
    Client findByClientId(String client_id);

}
