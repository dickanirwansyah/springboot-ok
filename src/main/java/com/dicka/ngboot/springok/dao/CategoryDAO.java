package com.dicka.ngboot.springok.dao;

import com.dicka.ngboot.springok.model.Category;

import java.util.List;

public interface CategoryDAO {

    boolean insertKategori(Category category);

    void updateKategori(Category category);

    void deleteKategori(Category category);

    Category findOneCategoryById(int idcategory);

    List<Category> findAllCategory();
}
