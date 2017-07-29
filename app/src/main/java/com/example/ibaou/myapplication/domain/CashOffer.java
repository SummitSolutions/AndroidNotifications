package com.example.ibaou.myapplication.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ibaou on 7/29/2017.
 */

public class CashOffer implements Serializable {

    private static final long serialVersionUID = -1L;

    private String uuid;
    private Date dateCreated;
    private String status;

    private Double bonusAmount;
    private String bonusType;
    private String bonusProgram;

    private CashRequest cashRequest;
    private Person offerrer;
    private Location location;

    public CashOffer() {
    }

    public CashOffer(Double bonusAmount, String bonusType, String bonusProgram, CashRequest cashRequest, Person offerrer, Location location) {
        this.bonusAmount = bonusAmount;
        this.bonusType = bonusType;
        this.bonusProgram = bonusProgram;
        this.cashRequest = cashRequest;
        this.offerrer = offerrer;
        this.location = location;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }

    public String getBonusProgram() {
        return bonusProgram;
    }

    public void setBonusProgram(String bonusProgram) {
        this.bonusProgram = bonusProgram;
    }

    public CashRequest getCashRequest() {
        return cashRequest;
    }

    public void setCashRequest(CashRequest cashRequest) {
        this.cashRequest = cashRequest;
    }

    public Person getOfferrer() {
        return offerrer;
    }

    public void setOfferrer(Person offerrer) {
        this.offerrer = offerrer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
