package com.chaves.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaves.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
