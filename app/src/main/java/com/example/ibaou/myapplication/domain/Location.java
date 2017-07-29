package com.example.ibaou.myapplication.domain;

import java.io.Serializable;

/**
 * Created by ibaou on 7/29/2017.
 */

public class Location implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long latitude;
    private Long longitude;

    public Location() {
    }

    public Location(Long latitude, Long longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
}
