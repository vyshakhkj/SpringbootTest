package net.guides.springboot2.springboot2jpacrudexample.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeAddress {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serial_number;
    @Column(name = "House_name",nullable = false)
    private String house_name;
    @Column(name = "Place",nullable = false)
    private String place;
    @Column(name = "District",nullable = false)
    private String district;
    @Column(name = "State",nullable = false)
    private String state;
    @Column(name = "Pincode",nullable = false)
    private long pincode;



    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
