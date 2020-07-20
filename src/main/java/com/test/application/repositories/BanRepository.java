package com.test.application.repositories;

import com.test.application.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BanRepository extends JpaRepository<Banner, Integer> {

    List<Banner> findByDeletedFalse();

    List<Banner> findByNameContainingAndDeletedFalse(String partOfBanName);

    List<Banner> findAllByIdInAndDeletedFalseOrderByPriceDesc(List<Integer> listId);

    boolean existsByName(String name);

}