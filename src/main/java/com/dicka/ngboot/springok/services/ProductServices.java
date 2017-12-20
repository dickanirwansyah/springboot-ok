package com.dicka.ngboot.springok.services;

import com.dicka.ngboot.springok.model.Product;

import java.util.List;

public interface ProductServices {

    List<Product> findAllProducts();

    Product findOneProductById(int idproduct);

    void insertProduct(Product product);

    void deleteProduct(Product product);

    Product updateProduct(Product product);

    List<Product> findProductByActive();

    boolean ifNameProductIsExist(String name);
}
