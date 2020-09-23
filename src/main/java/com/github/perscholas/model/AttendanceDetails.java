package com.github.perscholas.model;

//import javax.persistence.*;


import java.util.Date;


public class AttendanceDetails {

    private Integer ID;

    private Integer studenid;

    private String teacherid;

    private Date attendanceDate;

    private boolean is_present;

    private String createdby;

    private Date createdDate;



    public AttendanceDetails() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getStudenid() {
        return studenid;
    }

    public void setStudenid(Integer studenid) {
        this.studenid = studenid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public boolean isIs_present() {
        return is_present;
    }

    public void setIs_present(boolean is_present) {
        this.is_present = is_present;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
