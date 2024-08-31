package com.codewithprince.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithprince.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
