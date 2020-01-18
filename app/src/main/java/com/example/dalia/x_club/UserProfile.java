package com.example.dalia.x_club;


public class UserProfile {
    public String userAge;
    public String userEmail;
    public String userName;
    public String userPhone;
    public String userAddress;
    public String type;


    public UserProfile(){
    }

    public UserProfile(String userAge, String userEmail, String userName,String userAddress,String userPhone) {
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAddress=userAddress;
        this.userPhone=userPhone;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPhone(String userPhone){
        this.userPhone=userPhone;
    }
    public String getUserPhone(){
        return userPhone;
    }
    public void setUserAddress(String userAddress){
        this.userAddress=userAddress;
    }
    public String getUserAddress(){
        return userAddress;
    }


}