package model;

public class Room {

    private String address;
    private double price;
    private boolean available;

    public Room(String address, double price, boolean available) {
        this.address = address;
        this.price = price;
        this.available = available;
    }

    // Keep existing constructor for convenience
    public Room(String address, double price) {
        this(address, price, true);
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public String toFileString() {
        return address + "," + price + "," + available;
    }

    public String getDisplayString() {
        return "Address: " + address + " | Price: £" + price;
    }
}
