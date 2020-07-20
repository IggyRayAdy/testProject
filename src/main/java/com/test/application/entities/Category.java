package com.test.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "req_name", nullable = false)
    private String reqName;
    @Column(name = "is_deleted")
    private boolean deleted;

    @JsonIgnoreProperties(value = "category", allowSetters = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Banner> bannerList;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> ordersList) {
        this.bannerList = ordersList;
    }

    public boolean canDeleteCat() {
        if (bannerList != null) {
            for (Banner banner : bannerList) {
                if (!banner.isDeleted()) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> getListID() {
        List<Integer> listID = null;
        if (bannerList != null && bannerList.size() > 0) {
            listID = new ArrayList<>();
            for (Banner banner : bannerList) {
                listID.add(banner.getId());
            }
            return listID;
        }
        return null;
    }

    public String getNamesList() {
        StringBuilder bansNames= new StringBuilder();
        if (bannerList != null && bannerList.size() > 0) {

            for (Banner banner : bannerList) {
                bansNames.append(banner.getName()+", ");
            }
            return bansNames.toString();
        }
        return "This category didn't had any banners";
    }

    public static class Builder {
        private Category category;

        public Builder() {
            category = new Category();
        }

        public Builder withName(String name) {
            category.name = name;
            return this;
        }

        public Builder withReqName(String reqName) {
            category.reqName = reqName;
            return this;
        }

        public Builder withDeleted(boolean deleted) {
            category.deleted = deleted;
            return this;
        }

        public Category build() {
            return category;
        }
    }
}