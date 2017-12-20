package com.dicka.ngboot.springok.dao.daoimpl;

import com.dicka.ngboot.springok.dao.CategoryDAO;
import com.dicka.ngboot.springok.model.Category;
import com.dicka.ngboot.springok.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private CategoryServices categoryServices;

    @Override
    public boolean insertKategori(Category category) {
        try{

            if(categoryServices.ifCategoryByNamaIsExist(category.getName())){
                return false;
            }else{
                categoryServices.insertCategory(category);
                return true;
            }

        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateKategori(Category category) {
        try{
            categoryServices.updateCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKategori(Category category) {
        try{
            categoryServices.deleteCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Category findOneCategoryById(int idcategory) {
        try{
            return categoryServices.findOneCategoryById(idcategory);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findAllCategory() {
        try{
            return categoryServices.findAllCategory();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
