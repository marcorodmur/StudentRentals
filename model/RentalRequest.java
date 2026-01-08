package model;

public class RentalRequest {

    private String studentName;
    private Room room;
    private RequestStatus status;

    public RentalRequest(String studentName, Room room) {
        this.studentName = studentName;
        this.room = room;
        this.status = RequestStatus.PENDING;
    }

    public String getStudentName() {
        return studentName;
    }

    public Room getRoom() {
        return room;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getDisplayString() {
        return "Student: " + studentName + 
               " | Room: " + room.getAddress() + 
               " | Price: £" + room.getPrice() +
               " | Status: " + status;
    }
}
