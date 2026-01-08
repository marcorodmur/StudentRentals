import java.util.ArrayList;
import java.util.Scanner;

import model.Room;
import model.RoomManager;
import model.RentalRequest;
import model.RequestStatus;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RoomManager roomManager = new RoomManager();

        boolean running = true;

        while (running) {
            System.out.println("\n=== StudentRentals ===");
            System.out.println("1. Student");
            System.out.println("2. Homeowner");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> studentMenu(scanner, roomManager);
                case 2 -> homeownerMenu(scanner, roomManager);
                case 3 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    private static void homeownerMenu(Scanner scanner, RoomManager roomManager) {
        System.out.print("\nEnter room address: ");
        String address = scanner.nextLine();

        System.out.print("Enter room price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        roomManager.addRoom(address, price);
        System.out.println("Room added successfully.");
    }
    
    private static void studentMenu(Scanner scanner, RoomManager roomManager) {
        System.out.print("\nEnter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Room> results = roomManager.searchByMaxPrice(maxPrice);

        if (results.isEmpty()) {
        System.out.println("No rooms found.");
        } else {
            System.out.println("\nAvailable rooms:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getDisplayString());
            }

            System.out.print("\nEnter the number of the room you want to request (or 0 to cancel): ");
            int roomChoice = scanner.nextInt();
            scanner.nextLine();

            if (roomChoice > 0 && roomChoice <= results.size()) {
                Room chosenRoom = results.get(roomChoice - 1);
                RentalRequest request = new RentalRequest("StudentUser", chosenRoom);
                roomManager.addRequest(request);
                System.out.println("Request submitted!");
                System.out.println(request.getDisplayString());
            } else {
                System.out.println("Cancelled.");
            } 
        } 
    }

}
