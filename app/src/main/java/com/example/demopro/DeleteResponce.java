package com.example.demopro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteResponce {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("registrationfee")
    @Expose
    private String registrationfee;
    @SerializedName("examfee")
    @Expose
    private String examfee;
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
    private String collegefee;
    @SerializedName("totalfee")
    @Expose
    private String totalfee;
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


    public String getRegistrationfee() {
        return registrationfee;
    }

    public void setRegistrationfee(String registrationfee) {
        this.registrationfee = registrationfee;
    }

    public String getExamfee() {
        return examfee;
    }

    public void setExamfee(String examfee) {
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

    public String getCollegefee() {
        return collegefee;
    }

    public void setCollegefee(String collegefee) {
        this.collegefee = collegefee;
    }

    public String getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(String totalfee) {
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
