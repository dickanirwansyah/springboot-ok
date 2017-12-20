package com.dicka.ngboot.springok.dao;

import com.dicka.ngboot.springok.model.Product;

import java.util.List;

public interface ProductDAO {

    boolean insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    Product findOneProductById(int idproduct);

    List<Product> findAllProduct();

    List<Product> findProductByActive();
}
