package com.example.demo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "techify_project")
public class URLShortnerModule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int url_id;


    @Column(name="long_url")
    private String long_url;
    @Column(name="short_url")
    private String short_url;
    @Column(name="created_on")
    private Timestamp url_created_on;


    public int getUrl_id() {
        return url_id;
    }

    public void setUrl_id(int url_id) {
        this.url_id = url_id;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public Timestamp getUrl_created_on() {
        return url_created_on;
    }

    public void setUrl_created_on(Timestamp url_created_on) {
        this.url_created_on = url_created_on;
    }
}
