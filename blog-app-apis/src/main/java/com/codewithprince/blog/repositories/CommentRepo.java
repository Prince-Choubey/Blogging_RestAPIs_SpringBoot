package com.codewithprince.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithprince.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
