package com.example.ProjectCurd.services.serviceImp;

import com.example.ProjectCurd.entity.Orders;
import com.example.ProjectCurd.entity.Product;
import com.example.ProjectCurd.repository.OrdersRpo;
import com.example.ProjectCurd.repository.ProductRepo;
import com.example.ProjectCurd.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImp implements OrdersService {
    @Autowired
    private OrdersRpo ordersRpo;
    @Autowired
    private ProductServiceImp productServiceImp;

    @Override
    public Orders create(Orders orders) {
        Product product = null;
        for (int i = 0; i <orders.getProducts().size() ; i++) {
            product = orders.getProducts().get(i);
            product.setQty(product.getQty()-1);
            productServiceImp.update(product);
        }

        return ordersRpo.save(orders);
    }

    @Override
    public List<Orders> getAll() {
        return ordersRpo.findAll();
    }

    @Override
    public Orders getOneOrdersById(int id) {
        return ordersRpo.findById(id).get();
    }

    @Override
    public Orders update(Orders orders) {
        return ordersRpo.saveAndFlush(orders);
    }

    @Override
    public void delete(int id) {
        System.out.println(id);
        ordersRpo.deleteById(id);
    }
}
