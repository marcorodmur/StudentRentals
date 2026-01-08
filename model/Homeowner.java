package model;

public class Homeowner extends User {

    public Homeowner(int userId, String name) {
        super(userId, name);
    }

    public void addRoom(Room room) {
        room.setOwner(this);
    }

    public void reviewRequest(RentalRequest request, boolean accept) {
        if (accept) {
            request.accept();
        } else {
            request.reject();
        }
    }
}
