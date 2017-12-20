package com.dicka.ngboot.springok.dao.daoimpl;

import com.dicka.ngboot.springok.dao.ProductDAO;
import com.dicka.ngboot.springok.model.Product;
import com.dicka.ngboot.springok.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private ProductServices productServices;

    @Override
    public boolean insertProduct(Product product) {
        try{
            if(productServices.ifNameProductIsExist(product.getName())){
                System.out.println("data sudah ada : conflict 209 !");
                return false;
            }else{
                productServices.insertProduct(product);
                System.out.println("data berhasil disimpan : success 201 !");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateProduct(Product product) {
        try{
           productServices.updateProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        try{
            productServices.deleteProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Product findOneProductById(int idproduct) {
        try{
            return productServices.findOneProductById(idproduct);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAllProduct() {
        try {
            return productServices.findAllProducts();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findProductByActive() {
        try{
            return productServices.findProductByActive();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
