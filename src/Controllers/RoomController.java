package Controllers;

import Domains.RoomDomain;
import Services.RoomService;
import java.util.List;

public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    public void viewAllRooms() {
        List<RoomDomain> rooms = roomService.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.println("\n--- ALL ROOMS ---");
        for (RoomDomain room : rooms) {
            System.out.println("Room: " + room.getRoomNumber() +
                    " | Type: " + room.getType() +
                    " | Price: $" + room.getPricePerNight() + "/night" +
                    " | Capacity: " + room.getCapacity() + " guests" +
                    " | Status: " + room.getStatus());
        }
        System.out.println();
    }
}