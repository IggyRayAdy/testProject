package com.test.application.Repositories;

import com.test.application.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Category, Integer> {

    List<Category> findByDeletedFalse();

    Category findByName(String catName);

    Category findByReqName(String catReqName);

    boolean existsByName(String name);

    boolean existsByReqName(String reqName);

    List<Category> findByNameContaining(String partOfCatName);

}
