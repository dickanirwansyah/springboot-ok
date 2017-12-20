package com.dicka.ngboot.springok.controller;

import com.dicka.ngboot.springok.dao.CatalogDAO;
import com.dicka.ngboot.springok.mapper.CreateCatalog;
import com.dicka.ngboot.springok.mapper.UpdateCatalog;
import com.dicka.ngboot.springok.model.Catalog;
import com.dicka.ngboot.springok.utilities.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/data/api/")
@CrossOrigin(origins = {"*"})
public class ControllerCatalog {

    @Autowired
    private CatalogDAO catalogDAO;

    @GetMapping(value = "/catalogs")
    public ResponseEntity<List<Catalog>> findAll(){
        try{
            List<Catalog> listcat = catalogDAO.findAllCatalog();
            if(listcat.isEmpty()){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(listcat, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/catalogs/{idcatalog}")
    public ResponseEntity<Catalog> findOne(@PathVariable String idcatalog){
        try{
            Catalog catalog = catalogDAO.findCatalogById(Integer.parseInt(idcatalog));
            if(catalog == null){
                return new ResponseEntity<Catalog>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Catalog>(catalog, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/insertCatalog")
    public ResponseEntity<String> insertRest(@DTO(CreateCatalog.class)Catalog catalog){
        try{
            boolean valid = catalogDAO.insertCatalog(catalog);
            if(valid ==false){
                return new ResponseEntity<String>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/updateCatalog")
    public ResponseEntity<String> updateRest(@DTO(UpdateCatalog.class)Catalog catalog){
        try{
            catalogDAO.updateCatalog(catalog);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "/deleteCatalog/{idcatalog}")
    public ResponseEntity<String> deleteRest(@PathVariable String idcatalog){
        try{
            Catalog catalog = catalogDAO.findCatalogById(Integer.parseInt(idcatalog));
            if(catalog == null){
                return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            }
            catalogDAO.deleteCatalog(catalog);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
