package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        System.out.print("\t=====================================================");
        System.out.print("=====================================================");
        System.out.print("=====================================================\n");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tROOM RESERVATION SYSTEM");

        System.out.print("\t=====================================================");
        System.out.print("=====================================================");
        System.out.print("=====================================================\n");

        RoomManager Reserve = new RoomManager(3, 3, 3, 3);

        try{

            do {

                System.out.println("\n" +
                        "\t\t||--------------------------------------------||\n" +
                        "\t\t||\t\t\t\t\tMENU\t\t\t\t\t  ||\n" +
                        "\t\t||--------------------------------------------||\n" +
                        "\t\t||\t\t1: View All Rooms \t\t\t\t\t  ||\n" +
                        "\t\t||\t\t2: Reserve a Room \t\t\t\t\t  ||\n" +
                        "\t\t||\t\t3: Check Availability for an \t\t  ||" +
                        "\n\t\t||\t\t   Already Booked Room \t\t\t\t  ||\n" +
                        "\t\t||\t\t4: Cancel a Reservation \t\t\t  ||\n" +
                        "\t\t||\t\t5: Exit Program \t\t\t\t\t  ||\n" +
                        "\t\t||--------------------------------------------||\n");
                System.out.println("Input your Preferred action: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        Reserve.viewAllRooms();
                        break;

                    case 2:
                        System.out.println("Enter your name: ");
                        String name = input.next();
                        System.out.println("Enter your Phone Number: ");
                        String phoneNo = input.next();
                        System.out.println("Enter the Number of the Room you want to reserve: ");
                        int roomNum = input.nextInt();
                        Reserve.reserveRoom(roomNum, name, phoneNo);
                        break;

                    case 3:
                        System.out.println("Enter the Room Number you would like to re-book: ");
                        int roomNo = input.nextInt();
                        System.out.println("Enter your Name: ");
                        String yourName = input.next();
                        System.out.println("Enter your Phone Number: ");
                        String phone = input.next();
                        Reserve.simulateReservations(Reserve, roomNo, yourName, phone);
                        break;

                    case 4:
                        System.out.println("Enter your Room Number to cancel reservation: ");
                        int rooms = input.nextInt();
                        Reserve.cancelReservation(rooms);
                        break;

                    case 5:
                        System.out.println("Exiting the Room Reservation System.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Please input a valid option.");
                }
            }while (true);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}