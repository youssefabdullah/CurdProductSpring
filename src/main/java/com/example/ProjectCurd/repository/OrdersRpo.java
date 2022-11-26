package com.example.ProjectCurd.repository;

import com.example.ProjectCurd.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRpo extends JpaRepository<Orders,Integer> {
}
