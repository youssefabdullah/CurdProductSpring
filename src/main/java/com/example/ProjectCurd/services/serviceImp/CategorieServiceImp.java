package com.example.ProjectCurd.services.serviceImp;

import com.example.ProjectCurd.entity.Categories;
import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.repository.CategorieRepo;
import com.example.ProjectCurd.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService {
    @Autowired
    private CategorieRepo categorieRepo;

    @Override
    public Categories create(Categories categories) {
        return categorieRepo.save(categories);
    }

    @Override
    public List<Categories> getAll() {
        return categorieRepo.findAll();
    }

    @Override
    public Categories getOneCategorieById(int id) {
        return categorieRepo.findById(id).get();
    }

    @Override
    public List<Product> getOneCategorieByName(String name) {
        return categorieRepo.findByCategorname(name).getProducts();
    }

    @Override
    public Categories update(Categories categories) {
        return categorieRepo.saveAndFlush(categories);
    }

    @Override
    public void delete(int id) {
        categorieRepo.deleteById(id);
    }
}
