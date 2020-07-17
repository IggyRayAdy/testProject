package com.test.application.Repositories;

import com.test.application.Entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BanRepository extends JpaRepository<Banner, Integer> {
//public interface BanRepository extends CrudRepository<Banner, Integer> {

    boolean existsByName(String name);

    List<Banner> findByDeletedFalse();

    List<Banner> findByNameContaining(String partOfBanName);

//    List<Banner> findAllByIdInOrderByPriceDesc(List<Integer> listId);

    List<Banner> findAllByIdInAndDeletedFalseOrderByPriceDesc(List<Integer> listId);


}
