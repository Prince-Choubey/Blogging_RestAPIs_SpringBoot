package com.codewithprince.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithprince.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	
	

}
