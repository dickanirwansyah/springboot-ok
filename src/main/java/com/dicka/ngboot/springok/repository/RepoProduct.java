package com.dicka.ngboot.springok.repository;

import com.dicka.ngboot.springok.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProduct extends JpaRepository<Product, Integer> {
}
