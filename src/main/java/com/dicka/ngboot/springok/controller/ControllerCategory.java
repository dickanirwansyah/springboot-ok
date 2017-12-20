package com.dicka.ngboot.springok.controller;

import com.dicka.ngboot.springok.dao.CategoryDAO;
import com.dicka.ngboot.springok.mapper.CreateCategory;
import com.dicka.ngboot.springok.mapper.UpdateCategory;
import com.dicka.ngboot.springok.model.Category;
import com.dicka.ngboot.springok.utilities.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/data/api/")
@CrossOrigin(origins = {"*"})
public class ControllerCategory {

    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping(value = "/category")
    public ResponseEntity<Collection<Category>> getCategory(){
        try{
            Collection<Category> categories = categoryDAO.findAllCategory();
            if(categories.isEmpty()){
                return new ResponseEntity<Collection<Category>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/category/{idcategory}")
    public ResponseEntity<Category> findOneCategory(@PathVariable String idcategory){
        try{
            Category category = categoryDAO.findOneCategoryById(Integer.parseInt(idcategory));
            if(category == null){
                return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<Category>(category, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/insertCategory")
    public ResponseEntity<String> insertCategory(@DTO(CreateCategory.class)Category category){
        try{
            boolean valid = categoryDAO.insertKategori(category);
            if(valid == false){
                return new ResponseEntity<String>(HttpStatus.CONFLICT);
            }else{
                return new ResponseEntity<String>(HttpStatus.CREATED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping(value = "/updateCategory")
    public ResponseEntity<String> updateCategorys(@DTO(UpdateCategory.class)Category category){
        try{
            categoryDAO.updateKategori(category);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "/deleteCategory/{idcategory}")
    public ResponseEntity<String> deleteCategory(@PathVariable String idcategory){
        try{
            Category category = categoryDAO.findOneCategoryById(Integer.valueOf(idcategory));
            if(category == null){
                return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            }

            categoryDAO.deleteKategori(category);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
