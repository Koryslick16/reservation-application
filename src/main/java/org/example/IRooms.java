package org.example;

import java.util.Optional;

public interface IRooms {
    void viewAllRooms();
    void reserveRoom(int roomNumber, String name, String phoneNumber);
    void simulateReservations(RoomManager manager, int roomNo, String name, String phone);
    void cancelReservation(int roomNumber);
    Optional findRoom(int room);
}
