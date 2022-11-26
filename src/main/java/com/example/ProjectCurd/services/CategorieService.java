package com.example.ProjectCurd.services;

import com.example.ProjectCurd.entity.Categories;
import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.entity.Users;

import java.util.List;

public interface CategorieService {
    public Categories create(Categories categories);
    public List<Categories> getAll();
    public Categories getOneCategorieById(int id);
    public List<Product> getOneCategorieByName(String  name);
    public Categories update(Categories categories);
    public void delete(int id);
}
