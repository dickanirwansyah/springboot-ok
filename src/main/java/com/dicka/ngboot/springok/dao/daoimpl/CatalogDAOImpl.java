package com.dicka.ngboot.springok.dao.daoimpl;

import com.dicka.ngboot.springok.dao.CatalogDAO;
import com.dicka.ngboot.springok.model.Catalog;
import com.dicka.ngboot.springok.services.CatalogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogDAOImpl implements CatalogDAO {

    @Autowired
    private CatalogServices catalogServices;

    @Override
    public boolean insertCatalog(Catalog catalog) {
        try{
            if(catalogServices.ifCatalogIsExist(catalog.getName())){
                return false;
            }else{
                catalogServices.insertCatalog(catalog);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        catalogServices.updateCatalog(catalog);
    }

    @Override
    public void deleteCatalog(Catalog catalog) {
        catalogServices.deleteCatalog(catalog);
    }

    @Override
    public Catalog findCatalogById(int idcatalog) {
        try{
            return catalogServices.findCatalogById(idcatalog);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Catalog> findAllCatalog() {
        try{
            return catalogServices.getListCatalog();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
