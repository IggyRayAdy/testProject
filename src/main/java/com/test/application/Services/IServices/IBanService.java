package com.test.application.Services.IServices;

import com.test.application.Entities.Banner;
import com.test.application.EntitiesDTO.BannerDTO;

import java.util.List;

public interface IBanService {

    boolean createBan(BannerDTO bannerDTO, String catName);

    boolean updateBan(Banner reBanner, Banner banner);
//    boolean updateBanner(BannerDTO reBanner, Banner banner);

    boolean hideBan(Banner banner);

    boolean banNameIsUniq(String name);

    List<Banner> getBans();

    List<Banner> getBansBySearch(String searchWord);

    List<Banner> getActBansList(List<Integer> listId);

    Banner getBan(Integer id);

}
