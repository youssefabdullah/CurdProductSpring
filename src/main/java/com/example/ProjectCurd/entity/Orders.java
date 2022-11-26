package com.example.ProjectCurd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @ManyToMany
    @JoinTable(name = "order_product",joinColumns = {@JoinColumn(name ="order_id")},inverseJoinColumns = {@JoinColumn(name = "product_id")})
    List<Product> products;

}
