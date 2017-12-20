package com.dicka.ngboot.springok.services.serviceImpl;

import com.dicka.ngboot.springok.model.Category;
import com.dicka.ngboot.springok.repository.RepoCategory;
import com.dicka.ngboot.springok.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CategoryServiceImpl implements CategoryServices{

    @Autowired
    private RepoCategory repoCategory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category findOneCategoryById(int idcategory) {
        String hql = "from Category as cat where cat.idcategory=?";
        return (Category) entityManager.createQuery(hql).setParameter(1, idcategory)
                .getSingleResult();
    }

    @Override
    public void insertCategory(Category category) {
        repoCategory.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        if(!entityManager.contains(category))
            category = entityManager.merge(category);
        return category;
    }

    @Override
    public void deleteCategory(Category category) {
        entityManager.remove(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return repoCategory.findAll();
    }

    @Override
    public boolean ifCategoryByNamaIsExist(String name) {
        String hql = "from Category as cat where cat.name=?";
        int counted = entityManager.createQuery(hql).setParameter(1, name)
                .getResultList().size();
        return counted > 0 ? true : false;
    }
}
