package com.test.application.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_agetn")
    private String userAgent;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "date", updatable = false)
    private LocalDate date;

    /*@Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")*/

    @ManyToOne
    @JsonIgnoreProperties(value = "requestList", allowSetters = true)
    @JoinColumn(name = "banner_id")
    private Banner banner;

    public Request() {
    }

    public Request(String userAgent, String ipAddress, LocalDate date) {
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgetn) {
        this.userAgent = userAgetn;
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

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(userAgent, request.userAgent) &&
                Objects.equals(ipAddress, request.ipAddress) &&
                Objects.equals(date, request.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAgent, ipAddress, date);
    }

//    public static class Builder {
//
//        private Request request;
//
//        public Builder() {
//            request = new Request();
//        }
//
//        public Request.Builder withUserAgent(String userAgent) {
//            request.userAgent = userAgent;
//            return this;
//        }
//
//        public Request.Builder withIpAddress(String ipAddress) {
//            request.ipAddress = ipAddress;
//            return this;
//        }
//
//        public Request.Builder withDate(LocalDate date) {
//            request.date = date;
//            return this;
//        }
//
//        public Request build() {
//            return request;
//        }
//    }

}
