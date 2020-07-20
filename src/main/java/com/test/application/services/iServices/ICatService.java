package com.test.application.services.iServices;

import com.test.application.entities.Category;
import com.test.application.entitiesDTO.CategoryDTO;

import java.util.List;

public interface ICatService {

    boolean createCat(CategoryDTO categoryDTO);

    boolean updateCat(CategoryDTO reCategory, Category Category);
//    boolean updateCategory(Category reCategory, Category Category);

    boolean hideCat(Category category);

    boolean catNameIsUniq(String name, String reqName);

    List<Category> getCats();

    List<Category> getCatsBySearch(String partOfCatName);

    List<String> getCatsNames();

    Category getCat(Integer id);

    Category getCatByName(String catName);

    Integer getActBanIdFromCat(String reqIp);
}