package com.sumsol.android.common.domain;

import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class Preferences implements Serializable, JsonDocument{

    private static final long serialVersionUID = -1L;

    private int accessCounter = 0;
    private boolean tutorialComplete;
    private boolean tutorialSkipped;

    public Preferences(){

    }

    /*
     * Workers
     */

    public int incrementCounter( int increment ){
        this.accessCounter += increment;
        return this.accessCounter;
    }

    public boolean isFirstAccess() {
        return this.accessCounter <= 1 ;
    }

    /*
     * Getters / Setters
     */

    public boolean isTutorialComplete() {
        return tutorialComplete;
    }

    public void setTutorialComplete(boolean tutorialComplete) {
        this.tutorialComplete = tutorialComplete;
    }

    public boolean isTutorialSkipped() {
        return tutorialSkipped;
    }

    public void setTutorialSkipped(boolean tutorialSkipped) {
        this.tutorialSkipped = tutorialSkipped;
    }

    public int getAccessCounter() {
        return accessCounter;
    }

    public void setAccessCounter(int accessCounter) {
        this.accessCounter = accessCounter;
    }

    @Override
    public String toJson() {
        return new GsonBuilder().create().toJson(this, Preferences.class);
    }
}
