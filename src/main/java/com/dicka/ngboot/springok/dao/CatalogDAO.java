package com.dicka.ngboot.springok.dao;

import com.dicka.ngboot.springok.model.Catalog;

import java.util.List;

public interface CatalogDAO {

    boolean insertCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(Catalog catalog);

    Catalog findCatalogById(int idcatalog);

    List<Catalog> findAllCatalog();
}
