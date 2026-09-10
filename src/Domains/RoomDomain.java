package Domains;
import java.io.Serializable;
import java.util.UUID;

public class RoomDomain {
    private static final long serialVersionUID = 1L;
    UUID User_Id;
    private String roomNumber;
    private RoomType type;
    private double pricePerNight;
    private int capacity;
    private RoomStatus status;

    public RoomDomain(String roomNumber, RoomType type, double pricePerNight, int capacity, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.status = status;
    }

    public String getRoomNumber() { return roomNumber; }
    public RoomType getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public int getCapacity() { return capacity; }
    public RoomStatus getStatus() { return status; }

    public void setStatus(RoomStatus status) { this.status = status; }
}