package com.hung.oauthserver;


import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.oauthserver.entities.Post;
import com.hung.oauthserver.repositories.PostRepository;

@RestController
@RequestMapping("/post")
public class ApplicationController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @PostMapping("/add")
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }


}
