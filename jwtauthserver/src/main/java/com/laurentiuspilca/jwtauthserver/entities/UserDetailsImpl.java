package com.laurentiuspilca.jwtauthserver.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails{

    private UserApp userapp;
    
    /*
	 * Get roles and permissions and add them as a Set of GrantedAuthority
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		userapp.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getName()));
			r.getPermissions().forEach(p -> {
				authorities.add(new SimpleGrantedAuthority(p.getName()));
			});
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		return userapp.getPassword();
	}

	@Override
	public String getUsername() {
		return userapp.getUsername();
	}

	public String getEmail() {
		return userapp.getEmail();
	}

	public void setEmail(String email) {
		this.userapp.setEmail(email);;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
}
