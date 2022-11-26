package com.example.ProjectCurd.controller;



import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
    @GetMapping
    @RequestMapping("popularityMaxValue")
    public List<Product> getOne() {
        return productService.getAllPopularity();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Product getOne(@PathVariable int id) {
        return productService.getOneProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

}
//  {
//         "username": "youssef",
//         "password": "123"

//     }