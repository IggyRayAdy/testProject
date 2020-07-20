package com.test.application.controllers;

import com.test.application.entities.Category;
import com.test.application.entitiesDTO.CategoryDTO;
import com.test.application.services.BanService;
import com.test.application.services.CatService;
import com.test.application.utils.ResEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CatService catService;
    private final BanService banService;

    public CategoryController(CatService catService, BanService banService) {
        this.catService = catService;
        this.banService = banService;
    }

    @GetMapping
    public ResponseEntity<Object> getCategories() {
        return ResEntity.createResponseEntity(catService.getCats());
    }

    @GetMapping("/getCategory/{categoryId}")
    public ResponseEntity<Object> getCategory(
            @PathVariable("categoryId") Category category
    ) {
        return ResEntity.createResponseEntity(category);
    }

    @GetMapping("/getHide/{categoryName}")
    public ResponseEntity<Object> getHideCategory(
            @PathVariable("categoryName") Category category
    ) {
        return ResEntity.createResponseEntity(catService.getBanInfo(category));
    }

    @GetMapping("/{reqName}")
    public ResponseEntity<Object> getActBanFromCategory(
            @PathVariable("reqName") String categoryReqName

    ) {
        Integer banId = catService.getActBanIdFromCat(categoryReqName);
        if (banId != null) {
            return ResEntity.createResponseEntity(banService.getBan(banId).getContent());
        }
        return ResEntity.createResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{partName}")
    public ResponseEntity<Object> getCatsBySearch(
            @PathVariable("partName") String categoryPartName
    ) {
        List<Category> searchList = catService.getCatsBySearch(categoryPartName);
        if (searchList.size() == 0) {
            return ResEntity.createResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResEntity.createResponseEntity(searchList);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Object> addCategory(
            @Valid @ModelAttribute CategoryDTO categoryDTO
    ) {
        if (catService.createCat(categoryDTO)) {
            return ResEntity.createResponseEntity("Category " + categoryDTO.getName() + " is created");
        }
        return ResEntity.createResponseEntity("Category with this name/reqname already exist, create new name/reqname");
    }

    @GetMapping("/delete/{categoryId}")
    public ResponseEntity<Object> hideCategory(
            @PathVariable("categoryId") Category category
    ) {
        if (catService.hideCat(category)) {
            return ResEntity.createResponseEntity("Category is deleted");
        }
        return ResEntity.createResponseEntity("Category has active banners");
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable("categoryId") Category category,
            @Valid @ModelAttribute CategoryDTO reCategory
    ) {
        if (catService.updateCat(reCategory, category)) {
            return ResEntity.createResponseEntity("Category " + category.getName() + " is updated");
        }
        return ResEntity.createResponseEntity("Category " + category.getName() + " does't updated");

    }
}
