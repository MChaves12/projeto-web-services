package com.chaves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaves.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
