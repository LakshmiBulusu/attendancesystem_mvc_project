package com.github.perscholas.model;

//import javax.persistence.*;


//@Entity
//@Table(name ="accountinformation")
public class AccountInformation  {

 //   @Id
 //   @Column(name="username")
    private String username;

 //   @Basic
 //   @Column (name="password")
    private String password;


//    @Basic
  //  @Column (name="lastloginDate")
    private String lastloginDate;

    public AccountInformation() {
    }

    public AccountInformation(String username, String password, String lastloginDate) {
        this.username = username;
        this.password = password;
        this.lastloginDate = lastloginDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(String lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    @Override
    public String toString() {
        return "Accountinformation{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastloginDate='" + lastloginDate + '\'' +
                '}';
    }
}
