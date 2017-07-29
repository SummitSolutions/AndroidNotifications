package com.example.ibaou.myapplication.domain;

import java.io.Serializable;

/**
 * Created by ibaou on 7/29/2017.
 */

public class Person implements Serializable{


    private static final long serialVersionUID = -1L;

    private String uuid;
    private String nickname;
    private String firstName;
    private String lastName;
    private String avatar;

    private Double rating;

    private String country;
    private String city;

    public Person() {
    }

    public Person(String uuid, String nickname, String firstName, String lastName, Double rating,
                  String country, String city, String avatar) {
        super();
        this.uuid = uuid;
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.country = country;
        this.city = city;
        this.avatar = avatar;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
