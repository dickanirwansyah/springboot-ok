package com.dicka.ngboot.springok.controller;

import com.dicka.ngboot.springok.dao.CheckoutDAO;
import com.dicka.ngboot.springok.dao.ProductDAO;
import com.dicka.ngboot.springok.mapper.CreateCheckout;
import com.dicka.ngboot.springok.mapper.UpdateCheckout;
import com.dicka.ngboot.springok.model.Checkout;
import com.dicka.ngboot.springok.model.Product;
import com.dicka.ngboot.springok.utilities.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/data/api")
public class ControllerCheckout {

    @Autowired
    private CheckoutDAO checkoutDAO;

    @Autowired
    private ProductDAO productDAO;

    @PostMapping(value = "/checkout")
    public ResponseEntity<String> addCheckout(@DTO(CreateCheckout.class)Checkout checkout){
        /*
        try{
            checkoutDAO.insertCheckout(checkout);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        */
        try{
            checkoutDAO.insertCheckout(checkout);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping(value = "/updatecheck")
    public ResponseEntity<String> getUpdateCheckout(@DTO(UpdateCheckout.class)Checkout checkout){
        checkoutDAO.updateCheckout(checkout);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/findcheck/{idcheckout}")
    public ResponseEntity<Checkout> getFindById(@PathVariable String idcheckout){
        Checkout checkout = checkoutDAO.findOneByCheckoutId(Integer.parseInt(idcheckout));
        if(checkout == null){
            return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Checkout>(checkout, HttpStatus.OK);
    }

    @GetMapping(value = "/checkouts")
    public ResponseEntity<List<Checkout>> getListCheckout(){
        List<Checkout> checkoutList = checkoutDAO.findAllChecks();
        if(checkoutList.isEmpty()){
            return new ResponseEntity<List<Checkout>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Checkout>>(checkoutList, HttpStatus.OK);
    }

}
