package com.codinsaint.tutorial.spring.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codinsaint.tutorial.spring.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
