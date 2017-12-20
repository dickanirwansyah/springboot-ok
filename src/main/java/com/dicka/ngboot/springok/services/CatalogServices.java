package com.dicka.ngboot.springok.services;

import com.dicka.ngboot.springok.model.Catalog;

import java.util.List;

public interface CatalogServices {

    void insertCatalog(Catalog catalog);

    Catalog updateCatalog(Catalog catalog);

    void deleteCatalog(Catalog catalog);

    List<Catalog> getListCatalog();

    Catalog findCatalogById(int idcatalog);

    boolean ifCatalogIsExist(String name);
}
