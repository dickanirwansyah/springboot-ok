package com.dicka.ngboot.springok.services;

import com.dicka.ngboot.springok.model.Checkout;

import java.util.List;

public interface CheckoutServices {

    void insertCheckout(Checkout checkout);

    Checkout updateCheckout(Checkout checkout);

    Checkout findCheckoutById(int idcheckout);

    List<Checkout> findAllCheckout();

    boolean ifKodeCheckOutIsExist(int idcheckout);
}
