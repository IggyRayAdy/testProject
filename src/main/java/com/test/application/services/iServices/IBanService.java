package com.test.application.services.iServices;

import com.test.application.entities.Banner;
import com.test.application.entitiesDTO.BannerDTO;

import java.util.List;

public interface IBanService {

    boolean createBan(BannerDTO bannerDTO, String catName);

//    boolean updateBan(Banner reBanner, Banner banner);
    boolean updateBan(BannerDTO reBanner, Banner banner);

    boolean hideBan(Banner banner);

    boolean banNameIsUniq(String name);

    List<Banner> getBans();

    List<Banner> getBansBySearch(String searchWord);

    List<Banner> getActBansList(List<Integer> listId);

    Banner getBan(Integer id);

}
