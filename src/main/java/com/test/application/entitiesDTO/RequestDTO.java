package com.test.application.entitiesDTO;

import java.time.LocalDate;

public class RequestDTO {

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
