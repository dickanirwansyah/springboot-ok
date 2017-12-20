package com.dicka.ngboot.springok.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "catalog", catalog = "useruser")
public class Catalog implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcatalog", nullable = false)
    private int idcatalog;

    @Column(name = "name", nullable = false)
    private String name;
}
