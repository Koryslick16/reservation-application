package org.example;

public class Room {
    private int roomNumber;
    private RoomType roomtype;
    private Reservation booking;


    public Room(int room, RoomType roomtype) {
        this.roomNumber = room;
        this.roomtype = roomtype;
        this.booking = null;
    }

    public int getRoom() {
        return roomNumber;
    }

    public void setRoom(int room) {
        this.roomNumber = room;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    public synchronized boolean isReserved(){
        return booking != null;
    }

    public synchronized void reserve(String name, String phoneNumber){
        if(isReserved()){
            System.out.println("Room #" + roomNumber + " (" + roomtype + ") " + "is already reserved.");
        }else {
            this.booking = new Reservation(name, phoneNumber);
            System.out.println("Room #" + roomNumber + " (" + roomtype + ") " + "has been booked successfully.");
        }
    }

    public synchronized void cancelReservation(){
        if(isReserved()){
            System.out.println("Reservation for Room #" + roomNumber + " (" + roomtype + ") by " + booking.getGuest() + " has been canceled");
            this.booking = null;
        }else {
            System.out.println("Room #" + roomNumber + " (" + roomtype + ") " + " has not been booked.");
        }
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomtype + ") "  + "-> "+ (isReserved() ? "Reserved by "+ booking.getGuest() : "Available");
    }


}
