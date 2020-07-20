package com.test.application.controllers;

import com.test.application.entities.Banner;
import com.test.application.entitiesDTO.BannerDTO;
import com.test.application.services.BanService;
import com.test.application.utils.ResEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/banners")
public class BannerController {

    private final BanService banService;

    public BannerController(BanService banService) {
        this.banService = banService;
    }

    @GetMapping
    public ResponseEntity<Object> getBanners() {
        return ResEntity.createResponseEntity(banService.getBans());
    }

    @GetMapping("/getCategoriesNames")
    public ResponseEntity<Object> getCategoriesNames() {
        return ResEntity.createResponseEntity(banService.getCatsNames());
    }

    @GetMapping("/getBanner/{bannerId}")
    public ResponseEntity<Object> getBanner(
            @PathVariable("bannerId") Banner banner
    ) {
        return ResEntity.createResponseEntity(banner);
    }

    @GetMapping("/search/{partName}")
    public ResponseEntity<Object> getBansBySearch(
            @PathVariable(name = "partName") String bannerPartName
    ) {
        return ResEntity.createResponseEntity(banService.getBansBySearch(bannerPartName));
    }

    @PostMapping("/addBanner")
    public ResponseEntity<Object> addBanner(
            @Valid @ModelAttribute BannerDTO bannerDTO
    ) {
        if (banService.createBan(bannerDTO, bannerDTO.getCatName())) {
            return ResEntity.createResponseEntity("Banner " + bannerDTO.getName() + " is created");
        }
        return ResEntity.createResponseEntity("Banner is not created, check uniq banner name and chose category");
    }

    @GetMapping("/delete/{bannerId}")
    public ResponseEntity<Object> hideBanner(
            @PathVariable("bannerId") Banner banner
    ) {
        return ResEntity.createResponseEntity(banService.hideBan(banner));
    }

    @PostMapping("/update/{bannerId}")
    public ResponseEntity<Object> updateBanner(
            @PathVariable("bannerId") Banner banner,
            @Valid
            @ModelAttribute BannerDTO bannerDTO
    ) {
        return ResEntity.createResponseEntity(banService.updateBan(bannerDTO, banner));

    }
}