package com.dicka.ngboot.springok.repository;

import com.dicka.ngboot.springok.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCatalog extends JpaRepository<Catalog, Integer> {
}
