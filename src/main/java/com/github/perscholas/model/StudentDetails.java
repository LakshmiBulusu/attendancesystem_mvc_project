package com.github.perscholas.model;

import java.util.Date;

public class StudentDetails {

    private int studentid;
    private String firstname;
    private String lastname;
    private String address;
    private String emergencycontact;
    private String parentemailid;
    private String createdby;
    private Date createdate;
    private Date updateddate;
    private String updatedby;
    private String photoname;

    public StudentDetails() {
    }


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencycontact() {
        return emergencycontact;
    }

    public void setEmergencycontact(String emergencycontact) {
        this.emergencycontact = emergencycontact;
    }

    public String getParentemailid() {
        return parentemailid;
    }

    public void setParentemailid(String parentemailid) {
        this.parentemailid = parentemailid;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "studentid=" + studentid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", emergencycontact='" + emergencycontact + '\'' +
                ", parentemailid='" + parentemailid + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createdate=" + createdate +
                ", updateddate=" + updateddate +
                ", updatedby='" + updatedby + '\'' +
                ", photoname='" + photoname + '\'' +
                '}';
    }
}
