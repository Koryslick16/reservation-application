package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomManager implements IRooms{
     private final List<Room> rooms = new ArrayList<>();

    public RoomManager(int standard, int deluxe, int suite, int pent) {
         newRooms(standard, RoomType.STANDARD);
         newRooms(deluxe, RoomType.DELUXE);
         newRooms(suite, RoomType.SUITE);
         newRooms(pent, RoomType.PENTHOUSE);

    }
    private void newRooms(int count, RoomType type){
          int firstRoom = rooms.size() + 1;
          for (int i = 0; i < count; i++){
              rooms.add(new Room(firstRoom + i, type ));
          }
    }

    @Override
    public void viewAllRooms() {
         for (Room room : rooms){
             System.out.println(room);
         }
    }

    @Override
    public void reserveRoom(int roomNo, String name, String phoneNumber) {
       synchronized (this){
           findRoom(roomNo).ifPresent( room -> room.reserve(name, phoneNumber ));
       }
    }

    @Override
    public void simulateReservations(RoomManager manager, int roomNo, String name, String phone) {
            Thread t1 = new Thread(() -> manager.reserveRoom(roomNo, name, phone));
            Thread t2 = new Thread(() -> manager.reserveRoom(roomNo, name, phone));
            Thread t3 = new Thread(() -> manager.cancelReservation(roomNo));

            t1.start();
            t2.start();
            t3.start();

            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void cancelReservation(int roomNo) {
        synchronized (this){
            findRoom(roomNo).ifPresent(Room::cancelReservation);
        }
    }

    @Override
    public Optional<Room> findRoom(int roomm) {
       return rooms.stream().filter(r -> r.getRoom() == roomm).findFirst();
    }
}
