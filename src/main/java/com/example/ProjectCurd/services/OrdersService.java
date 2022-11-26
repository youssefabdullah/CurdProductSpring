package com.example.ProjectCurd.services;

import com.example.ProjectCurd.entity.Categories;
import com.example.ProjectCurd.entity.Orders;

import java.util.List;

public interface OrdersService {
    public Orders create(Orders orders);
    public List<Orders> getAll();
    public Orders getOneOrdersById(int id);
    public Orders update(Orders orders);
    public void delete(int id);
}
