package com.laurentiuspilca.jwtauthserver.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements ClientDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String clientid;
    
    private String secret;
    
    private String granttype;

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientid;
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return secret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {

		Set<String> s = new HashSet<String>();
        // Use add() method to add elements into the Set
        s.add("read");
        s.add("write");
		return s;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		Set<String> s = new HashSet<String>();
        s.add("password");
		return s;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(this.getGranttype()));
		return authorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}
}
