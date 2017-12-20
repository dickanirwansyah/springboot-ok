package com.dicka.ngboot.springok.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "checkout", catalog = "useruser")
public class Checkout implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcheckout", nullable = false)
    private int idcheckout;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "checkdate", nullable = false)
    private Date checkdate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "checkout_detil",
            joinColumns = @JoinColumn(name = "idcheckout",
                    referencedColumnName = "idcheckout"),
            inverseJoinColumns = @JoinColumn(name = "idproduct",
                    referencedColumnName = "idproduct"))
    private List<Product> productList;
}
