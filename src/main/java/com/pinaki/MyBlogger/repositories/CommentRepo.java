package com.pinaki.MyBlogger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinaki.MyBlogger.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
