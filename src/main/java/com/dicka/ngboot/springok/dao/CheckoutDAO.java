package com.dicka.ngboot.springok.dao;

import com.dicka.ngboot.springok.model.Checkout;

import java.util.List;

public interface CheckoutDAO {

    boolean insertCheckout(Checkout checkout);

    List<Checkout> findAllChecks();

    Checkout findOneByCheckoutId(int idcheckout);

    void updateCheckout(Checkout checkout);
}
