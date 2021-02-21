package com.example.healthmonitor;

import java.io.Serializable;

public class UserProfile {
    public String bloodPressure, bodyTemp, respiration, glucose, heartRate, oxygnSaturration, cholestrol;

    public UserProfile() {

    }

    public UserProfile(String bloodPressure, String bodyTemp, String respiration, String glucose, String heartRate, String oxygnSaturration, String cholestrol) {
        this.bloodPressure = bloodPressure;
        this.bodyTemp = bodyTemp;
        this.respiration = respiration;
        this.glucose = glucose;
        this.heartRate = heartRate;
        this.oxygnSaturration = oxygnSaturration;
        this.cholestrol = cholestrol;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(String bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getOxygnSaturration() {
        return oxygnSaturration;
    }

    public void setOxygnSaturration(String oxygnSaturration) {
        this.oxygnSaturration = oxygnSaturration;
    }

    public String getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(String cholestrol) {
        this.cholestrol = cholestrol;
    }
}