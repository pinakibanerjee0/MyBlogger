package com.pinaki.MyBlogger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinaki.MyBlogger.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
}
