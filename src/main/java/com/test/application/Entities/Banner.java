package com.test.application.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private double price;
    private String content;
    private boolean deleted = false;

    @ManyToOne
    @JsonIgnoreProperties(value = "bannerList", allowSetters = true)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnoreProperties(value = "banner", allowSetters = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "banner")
    private List<Request> requestList;

    public Banner() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public boolean checkRequest(Request request) {
        return requestList.contains(request);
    }

    public static class Builder {
        private Banner banner;

        public Builder() {
            banner = new Banner();
        }

        public Banner.Builder withName(String name) {
            banner.name = name;
            return this;
        }

        public Banner.Builder withPrice(double price) {
            banner.price = price;
            return this;
        }

        public Banner.Builder withContent(String content) {
            banner.content = content;
            return this;
        }

        public Banner.Builder withDeleted(boolean deleted) {
            banner.deleted = deleted;
            return this;
        }

        public Banner build() {
            return banner;
        }
    }

}