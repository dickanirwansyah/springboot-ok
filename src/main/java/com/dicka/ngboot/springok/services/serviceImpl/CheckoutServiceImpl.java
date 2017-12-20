package com.dicka.ngboot.springok.services.serviceImpl;

import com.dicka.ngboot.springok.model.Checkout;
import com.dicka.ngboot.springok.repository.RepoCheckout;
import com.dicka.ngboot.springok.services.CheckoutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class CheckoutServiceImpl implements CheckoutServices{

    @Autowired
    private RepoCheckout repoCheckout;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertCheckout(Checkout checkout) {
        try{
            entityManager.persist(checkout);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        try{
            if(!entityManager.contains(checkout))
                checkout = entityManager.merge(checkout);
            return checkout;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Checkout findCheckoutById(int idcheckout) {
        return repoCheckout.findOne(idcheckout);
    }

    @Override
    public List<Checkout> findAllCheckout() {
        return repoCheckout.findAll();
    }

    @Override
    public boolean ifKodeCheckOutIsExist(int idcheckout) {
        String hql="from Checkout as c where c.idcheckout=?";
        int counted = entityManager.createQuery(hql)
                .setParameter(1, idcheckout).getResultList().size();
        return counted > 0 ? true : false;
    }
}
