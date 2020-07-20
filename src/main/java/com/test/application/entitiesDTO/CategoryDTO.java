package com.test.application.entitiesDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoryDTO {

    @NotEmpty(message = "Please provide a name")
    @Length(min = 4, max = 12, message = "name value must be between 4 and 12 characters")
    private String name;
    @NotEmpty(message = "Please provide a reqName")
    @Length(min = 4, max = 12, message = "reqName value must be between 4 and 12 characters")
    private String reqName;
    private boolean deleted = false;


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

}


