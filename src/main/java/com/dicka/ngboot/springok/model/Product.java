package com.dicka.ngboot.springok.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "product",
        catalog = "useruser")
public class Product implements Serializable{

    @Id
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idproduct;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "price", nullable = false)
    int price;

    @Column(name = "active", nullable = false)
    Boolean active;

    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false)
    Category category;


}
