package Domains;

public class RoomDomain {
    public String RoomNumber;

    public RoomDomain(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }
}
