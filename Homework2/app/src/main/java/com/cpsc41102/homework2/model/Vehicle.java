package com.cpsc41102.homework2.model;

public class Vehicle {
    protected String mVIN;
    protected String mMake;
    protected String mModel;

    public Vehicle(String VIN, String make, String model) {
        mVIN = VIN;
        mMake = make;
        mModel = model;
    }

    public String getVIN() {
        return mVIN;
    }

    public void setVIN(String VIN) {
        mVIN = VIN;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }
}

