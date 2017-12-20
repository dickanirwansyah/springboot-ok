package com.dicka.ngboot.springok.dao.daoimpl;

import com.dicka.ngboot.springok.dao.CheckoutDAO;
import com.dicka.ngboot.springok.model.Checkout;
import com.dicka.ngboot.springok.services.CheckoutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutDAOImpl implements CheckoutDAO {

    @Autowired
    private CheckoutServices checkoutServices;

    @Override
    public boolean insertCheckout(Checkout checkout) {
        if(checkoutServices.ifKodeCheckOutIsExist(checkout.getIdcheckout())){
            return false;
        }else{
            checkoutServices.insertCheckout(checkout);
            return true;
        }
    }

    @Override
    public List<Checkout> findAllChecks() {
        return checkoutServices.findAllCheckout();
    }

    @Override
    public Checkout findOneByCheckoutId(int idcheckout) {
        return checkoutServices.findCheckoutById(idcheckout);
    }

    @Override
    public void updateCheckout(Checkout checkout) {
        checkoutServices.updateCheckout(checkout);
    }
}
