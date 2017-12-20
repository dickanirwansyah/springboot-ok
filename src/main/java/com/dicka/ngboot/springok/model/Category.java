package com.dicka.ngboot.springok.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "category", catalog = "useruser")
public class Category implements Serializable{

    @Id
    @Column(name = "idcategory", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcategory;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "active", nullable = false)
    Boolean active;

    @JsonIgnore
    @Column(nullable = true)
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
