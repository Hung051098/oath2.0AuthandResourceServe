package com.hung.oauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import com.hung.oauthserver.entities.Post;
import com.hung.oauthserver.entities.User;
import com.hung.oauthserver.repositories.PostRepository;
import com.hung.oauthserver.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class InitTestData implements ApplicationListener<ApplicationContextEvent> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {

        User u =new User(1l, "hung", "hung", "USER", true);
        u = userRepository.save(u);
        postRepository.save(new Post(0, "Post title nr1", "Post content nr1"));
        postRepository.save(new Post(0, "Post title nr2", "Post content nr2"));
        postRepository.save(new Post(0, "Post title nr3", "Post content nr3"));
        log.info("3 posts saved.");

        
        log.info("User saved." );
    }
}
