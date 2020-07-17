package com.test.application.Services;

import com.test.application.Entities.Banner;
import com.test.application.Entities.Category;
import com.test.application.EntitiesDTO.BannerDTO;
import com.test.application.Repositories.BanRepository;
import com.test.application.Repositories.CatRepository;
import com.test.application.Services.IServices.IBanService;
import org.springframework.stereotype.Service;

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
//    public boolean createBanner(BannerDTO bannerDTO, Category category) {
    public boolean createBan(BannerDTO bannerDTO, String catName) {

        Category category = catRepository.findByName(catName);

        if (!banNameIsUniq(bannerDTO.getName()) && category != null) {
            Banner banner = new Banner.Builder()
                    .withName(bannerDTO.getName())
                    .withPrice(bannerDTO.getPrice())
                    .withContent(bannerDTO.getContent())
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
    public boolean updateBan(Banner reBanner, Banner banner) {
//    public boolean updateBanner(BannerDTO reBanner, Banner banner) {
        if (reBanner.getName() != null) {
            banner.setName(reBanner.getName());
        } else if (reBanner.getPrice() != banner.getPrice() || reBanner.getPrice() != 0) {
            banner.setPrice(reBanner.getPrice());
        } else if (reBanner.getContent() != null) {
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
        return banRepository.findByNameContaining(searchWord);
    }

    @Override
    public List<Banner> getActBansList(List<Integer> listID) {
        return banRepository.findAllByIdInAndDeletedFalseOrderByPriceDesc(listID);
    }

}
