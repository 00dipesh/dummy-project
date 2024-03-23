package com.example.demopro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegNewModel implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("registrationfee")
    @Expose
    private int registrationfee;
    @SerializedName("examfee")
    @Expose
    private int examfee;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("mobileno")
    @Expose
    private String mobileno;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("collegefee")
    @Expose
    private int collegefee;
    @SerializedName("totalfee")
    @Expose
    private int totalfee;
    @SerializedName("passingyear")
    @Expose
    private String passingyear;
    @SerializedName("id")
    @Expose
    private String id;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getRegistrationfee() {
        return registrationfee;
    }

    public void setRegistrationfee(int registrationfee) {
        this.registrationfee = registrationfee;
    }

    public int getExamfee() {
        return examfee;
    }

    public void setExamfee(int examfee) {
        this.examfee = examfee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getCollegefee() {
        return collegefee;
    }

    public void setCollegefee(int collegefee) {
        this.collegefee = collegefee;
    }

    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public String getPassingyear() {
        return passingyear;
    }

    public void setPassingyear(String passingyear) {
        this.passingyear = passingyear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
