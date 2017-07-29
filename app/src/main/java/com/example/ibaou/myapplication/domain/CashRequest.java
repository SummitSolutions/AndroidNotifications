package com.example.ibaou.myapplication.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ibaou on 7/29/2017.
 */

public class CashRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    private String uuid;
    private Double amount;
    private String currency;
    private String requestStatus;
    private String compensationStatus;

    private Date dateCreated;
    private Date dateExpires;

    private Person requester;
    private Location location;


    public CashRequest() {
    }

    public CashRequest(String uuid, Double amount, String currency, Person requester, Location location) {
        super();
        this.uuid = uuid;
        this.amount = amount;
        this.currency = currency;
        this.requester = requester;
        this.location = location;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getCompensationStatus() {
        return compensationStatus;
    }

    public void setCompensationStatus(String compensationStatus) {
        this.compensationStatus = compensationStatus;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    public Person getRequester() {
        return requester;
    }

    public void setRequester(Person requester) {
        this.requester = requester;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
