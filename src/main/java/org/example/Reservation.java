package org.example;

public class Reservation {
    private String guest;
    private String phoneNumber;

    public Reservation(String guest, String phoneNumber) {
        this.guest = guest;
        this.phoneNumber = phoneNumber;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
