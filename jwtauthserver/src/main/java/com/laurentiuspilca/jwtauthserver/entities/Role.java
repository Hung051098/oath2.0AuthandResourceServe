package com.laurentiuspilca.jwtauthserver.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "permission_role", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "permission_id", referencedColumnName = "id") })
	private List<Permission> permissions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}