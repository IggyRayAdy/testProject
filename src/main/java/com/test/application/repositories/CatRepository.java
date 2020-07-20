package com.test.application.repositories;

import com.test.application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Category, Integer> {

    List<Category> findByNameContainingAndDeletedFalse(String partOfCatName);

    List<Category> findByDeletedFalse();

    Category findByName(String catName);

    Category findByReqName(String catReqName);

    boolean existsByName(String name);

    boolean existsByReqName(String reqName);
}
