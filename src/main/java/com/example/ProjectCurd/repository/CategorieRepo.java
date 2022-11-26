package com.example.ProjectCurd.repository;

import com.example.ProjectCurd.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categories,Integer> {
    Categories findByCategorname(String categorname);
}
