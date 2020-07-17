package com.test.application.Controllers;

import com.test.application.Entities.Banner;
import com.test.application.EntitiesDTO.BannerDTO;
import com.test.application.Services.BanService;
import com.test.application.Utils.ResEntity;
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

    @GetMapping("/getBanner/{bannerId}")
    public ResponseEntity<Object> getBanner(
            @PathVariable("bannerId") Banner banner
    ) {
        return ResEntity.createResponseEntity(banner);
    }

    @GetMapping("/search/{partName}")
    public ResponseEntity<Object> getBansBySearch(
            @PathVariable(name = "partName") String partName
    ) {
        return ResEntity.createResponseEntity(banService.getBansBySearch(partName));
    }

    @PostMapping("/addBanner")
    public ResponseEntity<Object> addBanner(
            @Valid @RequestBody BannerDTO bannerDTO
//            @RequestParam(name = "catName") String catName
    ) {
        if (banService.createBan(bannerDTO, bannerDTO.getCatName())) {
            return ResEntity.createResponseEntity("Banner " + bannerDTO.getName() + " is created");
        }
        return ResEntity.createResponseEntity("Banner is not created, check uniq banner name and chose category");
    }

    @PostMapping("/delete/{bannerId}")
    public ResponseEntity<Object> hideBanner(
            @PathVariable("bannerId") Banner banner
    ) {
        return ResEntity.createResponseEntity(banService.hideBan(banner));
    }

    @PostMapping("/update/{bannerId}")
    public ResponseEntity<Object> updateBanner(
            @PathVariable("bannerId") Banner banner,
            @RequestBody Banner reBanner
//          @Valid  @RequestBody BannerDTO bannerDTO
    ) {
        return ResEntity.createResponseEntity(banService.updateBan(reBanner, banner));

    }
}