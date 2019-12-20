package com.netas.challenge1.challenge1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Devices")
public class Device {

    @Id
    private long deviceID;
    @Column
    private String model;
    @Column
    private String brand;
    @Column
    private String os;
    @Column
    private String osVersion;

    public Device(String model, String brand, String os, String osVersion){

        this.model = model;
        this.brand = brand;
        this.os = os;
        this.osVersion = osVersion;
    }

    public Device(){}

    public long getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(long deviceID) {
        this.deviceID = deviceID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
}
