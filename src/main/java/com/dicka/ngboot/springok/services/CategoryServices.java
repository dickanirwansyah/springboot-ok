package com.dicka.ngboot.springok.services;

import com.dicka.ngboot.springok.model.Category;

import java.util.List;

public interface CategoryServices {

    Category findOneCategoryById(int idcategory);

    void insertCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);

    List<Category> findAllCategory();

    boolean ifCategoryByNamaIsExist(String name);
}
