package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomManager {

    private ArrayList<Room> rooms;
    private static final String FILE_NAME = "rooms.txt";
    
    private ArrayList<RentalRequest> requests = new ArrayList<>();
    
    public void addRequest(RentalRequest request) {
    requests.add(request); 
    }

    public ArrayList<RentalRequest> getRequests() {
        return requests;
    }

    public RoomManager() {
        rooms = new ArrayList<>();
        loadRoomsFromFile();
    }

    private void loadRoomsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");

                if (parts.length == 3) {
                    String address = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    boolean available = Boolean.parseBoolean(parts[2]);
                    rooms.add(new Room(address, price, available));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading rooms.");
        }
    }

    public void addRoom(String address, double price) {
        Room room = new Room(address, price);
        rooms.add(room);
        saveRoomToFile(room);
    }

    private void saveRoomToFile(Room room) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(room.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving room.");
        }
    }

    public ArrayList<Room> searchByMaxPrice(double maxPrice) {
        ArrayList<Room> results = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getPrice() <= maxPrice) {
                results.add(room);
            }
        }
        return results;
    }
}
