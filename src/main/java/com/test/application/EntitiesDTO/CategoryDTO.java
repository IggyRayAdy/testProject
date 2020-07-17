package com.test.application.EntitiesDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoryDTO {

    @NotEmpty(message = "Please provide a name")
    @Length(min = 4, max = 12)
    private String name;
    @NotEmpty(message = "Please provide a reqName")
    @Length(min = 4, max = 12)
    private String reqName;
    private boolean deleted = false;

    private String partOfName;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, String reqName, boolean deleted) {
        this.name = name;
        this.reqName = reqName;
        this.deleted = deleted;
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

    //////////////////////////////
    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
//////////////////////////////

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", reqName='" + reqName + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}


