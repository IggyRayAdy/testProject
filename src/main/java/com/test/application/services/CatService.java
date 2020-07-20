package com.test.application.services;

import com.test.application.entities.Banner;
import com.test.application.entities.Category;
import com.test.application.entities.Request;
import com.test.application.entitiesDTO.CategoryDTO;
import com.test.application.repositories.CatRepository;
import com.test.application.services.iServices.ICatService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CatService implements ICatService {

    private final CatRepository catRepository;
    private final ReqService reqService;
    private final BanService banService;
    private final HttpServletRequest request;

    public CatService(BanService banService, CatRepository catRepository, HttpServletRequest request,
                      ReqService reqService) {
        this.catRepository = catRepository;
        this.banService = banService;
        this.request = request;
        this.reqService = reqService;
    }

    @Override
    public boolean createCat(CategoryDTO categoryDTO) {
        if (catNameIsUniq(categoryDTO.getName(), categoryDTO.getReqName())) {
            Category category = new Category.Builder()
                    .withName(categoryDTO.getName())
                    .withReqName(categoryDTO.getReqName())
                    .withDeleted(categoryDTO.isDeleted())
                    .build();
            catRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean hideCat(Category category) {
        if (category.canDeleteCat()) {
            category.setDeleted(true);
            catRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCat(CategoryDTO reCategory, Category category) {

        if (!reCategory.getName().equals(category.getName())) {
            category.setName(reCategory.getName());
        }
        if (!reCategory.getReqName().equals(category.getReqName())) {
            category.setReqName(reCategory.getReqName());
        }
            catRepository.save(category);
            return true;
    }

    @Override
    public List<Category> getCats() {

        return catRepository.findByDeletedFalse();
    }

    @Override
    public Category getCat(Integer id) {
        return catRepository.getOne(id);
    }

    @Override
    public boolean catNameIsUniq(String name, String reqName) {
        return (!catRepository.existsByName(name) && !catRepository.existsByReqName(reqName));
    }

    @Override
    public List<String> getCatsNames() {
        List<String> categoryNames = new ArrayList<>();
        for (Category category : catRepository.findAll()) {
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

    @Override
    public Category getCatByName(String catName) {
        return catRepository.findByName(catName);
    }

    @Override
    public Integer getActBanIdFromCat(String catReqName) {

        String reqUA = request.getHeader("User-Agent");
        String reqIp = request.getRemoteAddr();

        Category category = catRepository.findByReqName(catReqName);
        List<Integer> banListID = category.getListID();

        if (banListID != null) {

            Request request = new Request(reqUA, reqIp, LocalDate.now());
            List<Banner> actualBan = banService.getActBansList(banListID);

            for (Banner banner : actualBan) {
                if (!banner.checkRequest(request)) {
                    request.setBanner(banner);
                    banner.setRequestList(Arrays.asList(request));
                    reqService.createReq(request);
                    return banner.getId();
                }
            }
        }
        return null;
    }

    @Override
    public List<Category> getCatsBySearch(String partOfName) {
        return catRepository.findByNameContainingAndDeletedFalse(partOfName);
    }

    public String getBanInfo(Category category) {
        return category.getNamesList();
    }

}
