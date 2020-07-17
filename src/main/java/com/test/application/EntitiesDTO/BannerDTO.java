package com.test.application.EntitiesDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BannerDTO {

    @NotEmpty(message = "Please provide a name")
    @Length(min = 4, max = 12)
    private String name;

    @NotNull
    @Min(0)
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

    @Override
    public String toString() {
        return "BannerDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
