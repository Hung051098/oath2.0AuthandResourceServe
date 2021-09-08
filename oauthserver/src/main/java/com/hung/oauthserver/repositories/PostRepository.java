package com.hung.oauthserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hung.oauthserver.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
