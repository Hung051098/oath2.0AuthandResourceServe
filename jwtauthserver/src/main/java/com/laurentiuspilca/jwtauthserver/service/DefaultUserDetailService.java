//package com.laurentiuspilca.jwtauthserver.service;
//
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.laurentiuspilca.jwtauthserver.repositories.UserRepository;
//
//@Service
//public class DefaultUserDetailService implements UserDetailsService{
//
//	@Autowired
//    private UserRepository repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return repo
//                .findByUsername(username)
//                .map(u -> new org.springframework.security.core.userdetails.User(
//                u.getUsername(),
//                u.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                AuthorityUtils.createAuthorityList()))
//                .orElseThrow(() -> new UsernameNotFoundException("No user with "
//                        + "the name " + username + "was found in the database"));
//    }
//}
