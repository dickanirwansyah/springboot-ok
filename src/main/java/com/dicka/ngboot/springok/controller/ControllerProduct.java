package com.dicka.ngboot.springok.controller;

import com.dicka.ngboot.springok.dao.ProductDAO;
import com.dicka.ngboot.springok.mapper.CreateProduct;
import com.dicka.ngboot.springok.mapper.UpdateProduct;
import com.dicka.ngboot.springok.model.Product;
import com.dicka.ngboot.springok.utilities.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/data/api")
@CrossOrigin(origins = {"*"})
public class ControllerProduct {

    @Autowired
    private ProductDAO productDAO;

    //----find all product
    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getListProduct(){
        List<Product> productList = productDAO.findAllProduct();
        if(productList.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //--find product berdasarkan yang status aktive
    @GetMapping(value = "/productactive")
    public ResponseEntity<List<Product>> getActiveProduct(){
        List<Product> productActive = productDAO.findProductByActive();
        if(productActive.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(productActive, HttpStatus.OK);
    }

    //---insert product
    @PostMapping(value = "/insertProduct")
    public ResponseEntity<String> insertProduct(@DTO(CreateProduct.class)Product product){
        try{
            boolean validate = productDAO.insertProduct(product);
            if(validate == false){
                return new ResponseEntity<String>(HttpStatus.CONFLICT);
            }else{
                return new ResponseEntity<String>(HttpStatus.CREATED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //--update product
    @PutMapping(value = "/updateProduct")
    public ResponseEntity<String> updateProduct(@DTO(UpdateProduct.class)Product product){
        try{
            productDAO.updateProduct(product);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //---delete product
    @DeleteMapping(value = "/deleteProduct/{idproduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable String idproduct){
        try{
            Product product = productDAO.findOneProductById(Integer.parseInt(idproduct));
            if(product == null){
                return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            }
            productDAO.deleteProduct(product);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
