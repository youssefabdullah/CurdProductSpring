package com.example.ProjectCurd.services;

import com.example.ProjectCurd.entity.Product;

import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> getAll();
    public List<Product> getAllPopularity();
    public Product getOneProduct(int id);
    public Product update(Product product);
    public void delete(int id);
}
