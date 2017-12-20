package com.dicka.ngboot.springok.repository;

import com.dicka.ngboot.springok.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCategory extends JpaRepository<Category, Integer> {
}
