package com.test.application.EntitiesDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class RequestDTO {

    /*@NotEmpty(message = "Please provide a name")
    @Length(min = 4, max = 12)*/
    private String userAgent;
    private String ipAddress;
    private LocalDate date = LocalDate.now();

    public RequestDTO() {
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
