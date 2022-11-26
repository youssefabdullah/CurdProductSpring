package com.example.ProjectCurd.controller;

import com.example.ProjectCurd.entity.Orders;
import com.example.ProjectCurd.entity.Users;
import com.example.ProjectCurd.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public List<Orders> getAll() {
        return ordersService.getAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public Orders getOne(@PathVariable int id) {
        return ordersService.getOneOrdersById(id);
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders orders) {
        return ordersService.create(orders);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Orders update(@PathVariable int id, @RequestBody Orders orders) {
        return ordersService.update(orders);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        ordersService.delete(id);
    }
}
//{
//        "id": 2,
//        "name_ar": "product2",
//        "name_en": "product2",
//        "price": 20,
//        "qty": 5,
//        "image": "j"
//        },
//        {
//        "id": 3,
//        "name_ar": "product3",
//        "name_en": "product3",
//        "price": 30,
//        "qty": 5,
//        "image": "j"
//        }