package com.example.ProjectCurd.services.serviceImp;

import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.repository.ProductRepo;
import com.example.ProjectCurd.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImp(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product create(Product product) {

        return productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getAllPopularity() {

        return productRepo.findAll().stream()
                .sorted((o1, o2) -> o2.getPrice()-o1.getPrice())
                .collect(Collectors.toList());
    }

    @Override
    public Product getOneProduct(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
