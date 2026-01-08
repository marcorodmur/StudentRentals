package model;

public class Student extends User {

    public Student(int userId, String name) {
        super(userId, name);
    }

    public void searchRooms() {
        // Interaction handled by StudentRentalsSystem
    }

    public RentalRequest submitRentalRequest(Room room, int requestId) {
        return new RentalRequest(requestId, this, room);
    }
}
