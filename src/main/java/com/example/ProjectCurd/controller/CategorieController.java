package com.example.ProjectCurd.controller;

import com.example.ProjectCurd.entity.Categories;
import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categories> getAll() {
        return categorieService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Categories getOne(@PathVariable int id) {
        return categorieService.getOneCategorieById(id);
    }

    @GetMapping
    @RequestMapping("products/{name}")
    public List<Product> getProductsByCategoryName(@PathVariable String name) {
        return categorieService.getOneCategorieByName(name);
    }

    @PostMapping
    public Categories addProduct(@RequestBody Categories categories) {
        return categorieService.create(categories);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Categories update(@PathVariable int id, @RequestBody Categories categories) {
        return categorieService.update(categories);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        categorieService.delete(id);
    }

}
