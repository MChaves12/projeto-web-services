package com.chaves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaves.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
