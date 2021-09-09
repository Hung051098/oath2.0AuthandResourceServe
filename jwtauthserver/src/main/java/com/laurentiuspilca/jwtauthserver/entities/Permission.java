package com.laurentiuspilca.jwtauthserver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
