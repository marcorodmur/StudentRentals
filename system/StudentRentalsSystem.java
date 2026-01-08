package system;

import model.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Core system logic for StudentRentals.
 */
public class StudentRentalsSystem {

    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Linear search for available rooms under a maximum price.
     */
    public List<Room> searchRooms(double maxPrice) {
        List<Room> results = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getPrice() <= maxPrice) {
                results.add(room);
            }
        }
        return results;
    }
    public List<Room> getRooms() {
    return rooms;
    }
 
}
