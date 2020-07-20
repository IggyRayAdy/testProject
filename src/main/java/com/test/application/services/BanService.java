package com.test.application.services;

import com.test.application.entities.Banner;
import com.test.application.entities.Category;
import com.test.application.entitiesDTO.BannerDTO;
import com.test.application.repositories.BanRepository;
import com.test.application.repositories.CatRepository;
import com.test.application.services.iServices.IBanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BanService implements IBanService {

    private final BanRepository banRepository;
    private final CatRepository catRepository;

    public BanService(BanRepository banRepository, CatRepository catRepository) {
        this.banRepository = banRepository;
        this.catRepository = catRepository;
    }

    @Override
    public boolean createBan(BannerDTO bannerDTO, String catName) {

        Category category = catRepository.findByName(catName);

        if (!banNameIsUniq(bannerDTO.getName()) && category != null) {
            Banner banner = new Banner.Builder()
                    .withName(bannerDTO.getName())
                    .withContent(bannerDTO.getContent())
                    .withPrice(bannerDTO.getPrice())
                    .withDeleted(bannerDTO.isDeleted())
                    .build();

            banner.setCategory(category);
            category.setBannerList(Arrays.asList(banner));
            banRepository.save(banner);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBan(BannerDTO reBanner, Banner banner) {

        if (!reBanner.getName().equals(banner.getName())) {
            banner.setName(reBanner.getName());
        }
        if (banner.getPrice() != reBanner.getPrice()) {
            banner.setPrice(reBanner.getPrice());
        }
        if (!reBanner.getContent().equals(banner.getContent())) {
            banner.setContent(reBanner.getContent());
        }

        banRepository.save(banner);
        return true;
    }

    @Override
    public boolean hideBan(Banner banner) {
        banner.setDeleted(true);
        banRepository.save(banner);
        return true;
    }

    @Override
    public List<Banner> getBans() {
        return banRepository.findByDeletedFalse();
    }

    @Override
    public Banner getBan(Integer id) {
        if (id != null) {
            return banRepository.getOne(id);
        }
        return null;
    }

    @Override
    public boolean banNameIsUniq(String name) {

        return banRepository.existsByName(name);
    }

    @Override
    public List<Banner> getBansBySearch(String searchWord) {
        return banRepository.findByNameContainingAndDeletedFalse(searchWord);
    }

    @Override
    public List<Banner> getActBansList(List<Integer> listID) {
        return banRepository.findAllByIdInAndDeletedFalseOrderByPriceDesc(listID);
    }

    public List<String> getCatsNames() {
        List<String> categoryNames = new ArrayList<>();
        for (Category category : catRepository.findAll()) {
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

}