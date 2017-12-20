package com.dicka.ngboot.springok.services.serviceImpl;

import com.dicka.ngboot.springok.model.Product;
import com.dicka.ngboot.springok.repository.RepoProduct;
import com.dicka.ngboot.springok.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductServiceImpl implements ProductServices{

    @Autowired
    private RepoProduct repoProduct;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAllProducts() {
        return repoProduct.findAll();
    }

    @Override
    public Product findOneProductById(int idproduct) {
        String hql="from Product as prod where prod.idproduct=?";
        return (Product) entityManager.createQuery(hql).setParameter(1, idproduct)
                .getSingleResult();
    }

    @Override
    public void insertProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if(!entityManager.contains(product))
            product = entityManager.merge(product);
        return product;
    }

    @Override
    public List<Product> findProductByActive() {
        String hql="from Product as prod where prod.active=true";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public boolean ifNameProductIsExist(String name) {
        String hql="from Product as prod where prod.name=?";
        int counted = entityManager.createQuery(hql).setParameter(1, name)
                .getResultList().size();
        return counted > 0 ? true : false;
    }

    @Override
    public void deleteProduct(Product product){
        repoProduct.delete(product);
    }
}
