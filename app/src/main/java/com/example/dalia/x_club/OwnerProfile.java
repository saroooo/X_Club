package com.example.dalia.x_club;


public class OwnerProfile {
    public String ownerAge;
    public String ownerEmail;
    public String ownerName;
    public String ownerPhone;
    public String ownerAddress;
    public String clubName;
    public String clubAddress;
    public String type;
    public OwnerProfile(){
    }

    public OwnerProfile(String ownerAge, String ownerEmail, String ownerName,String ownerAddress,String ownerPhone,String clubName,String  clubAddress ) {
        this.ownerAge = ownerAge;
        this.ownerEmail = ownerEmail;
        this.ownerName = ownerName;
        this.ownerAddress=ownerAddress;

        this.ownerPhone=ownerPhone;
        this.clubName=clubName;
        this.clubAddress=clubAddress;
    }

    public String getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(String ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setOwnerPhone(String ownerPhone){
        this.ownerPhone=ownerPhone;
    }
    public String getOwnerPhone(){
        return ownerPhone;
    }
    public void setOwnerAddress(String ownerAddress){
        this.ownerAddress=ownerAddress;
    }
    public String getOwnerAddress(){
        return ownerAddress;
    }
    public void setClubName(String clubName){
        this.clubName=clubName;
    }
    public String getClubName(){
        return clubName;
    }
    public void setClubAddress(String clubAddress){
        this.clubAddress=clubAddress;
    }
    public String getClubAddress(){
        return clubAddress;
    }
}