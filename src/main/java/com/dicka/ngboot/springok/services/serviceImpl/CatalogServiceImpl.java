package com.dicka.ngboot.springok.services.serviceImpl;

import com.dicka.ngboot.springok.model.Catalog;
import com.dicka.ngboot.springok.repository.RepoCatalog;
import com.dicka.ngboot.springok.services.CatalogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class CatalogServiceImpl implements CatalogServices {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RepoCatalog repoCatalog;

    @Override
    public void insertCatalog(Catalog catalog) {
        try{
            entityManager.persist(catalog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        try{
            if(!entityManager.contains(catalog))
                catalog = entityManager.merge(catalog);
            return catalog;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCatalog(Catalog catalog) {
        entityManager.remove(catalog);
    }

    @Override
    public List<Catalog> getListCatalog() {
        return repoCatalog.findAll();
    }

    @Override
    public Catalog findCatalogById(int idcatalog) {
        return repoCatalog.findOne(idcatalog);
    }

    @Override
    public boolean ifCatalogIsExist(String name) {
        String hql="from Catalog as cat where cat.name=?";
        int counted = entityManager.createQuery(hql).setParameter(1, name)
                .getResultList().size();
        return counted > 0 ? true : false;
    }
}
