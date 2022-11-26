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
@Table(name = "CAREGORIES")
public class Categories {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String categorname;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "categ_fk",referencedColumnName = "id")
    List<Product> products;

}
