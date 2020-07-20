package com.test.application.entitiesDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class BannerDTO {

    @NotEmpty(message = "Please provide a name")
    @Length(min = 4, max = 12, message = "name value must be between 4 and 12 characters")
    private String name;
    @NotNull
    @Digits(integer=6, fraction=2, message = "max 6 digits and 2 digits after decimal point")
    private double price;
    @NotEmpty(message = "Please provide a content")
    @Length(min = 0, max = 255)
    private String content;

    private boolean deleted = false;

    private String catName;
    private String partOfName;

    public BannerDTO() {
    }

    public BannerDTO(String name, double price, String content, boolean deleted) {
        this.name = name;
        this.price = price;
        this.content = content;
        this.deleted = deleted;
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

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
}