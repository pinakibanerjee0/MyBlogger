package com.pinaki.MyBlogger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinaki.MyBlogger.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
