package com.dicka.ngboot.springok.repository;

import com.dicka.ngboot.springok.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCheckout extends JpaRepository<Checkout, Integer>{
}
