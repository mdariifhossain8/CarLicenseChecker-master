package com.sqliteproject.bitm.realthinkers.carlicensechecker.models;



public class Car {

    private int id;
    private String modelNo;
    private String chassisNo;
    private String owner;
    private String licenseNo;
    private String expDate;

    public Car(int id, String modelNo, String chassisNo, String owner, String licenseNo, String expDate) {
        this.id = id;
        this.modelNo = modelNo;
        this.chassisNo = chassisNo;
        this.owner = owner;
        this.licenseNo = licenseNo;
        this.expDate = expDate;
    }

    public Car(String modelNo, String chassisNo, String owner, String licenseNo, String expDate) {
        this.modelNo = modelNo;
        this.chassisNo = chassisNo;
        this.owner = owner;
        this.licenseNo = licenseNo;
        this.expDate = expDate;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
