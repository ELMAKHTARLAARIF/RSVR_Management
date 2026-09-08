package Repositories;

import Domains.RoomDomain;
import Domains.RoomDomain;
import Domains.RoomType;
import Domains.RoomStatus;
import Repositories.Implementation.IMemoryRoomRepository;

public class RoomRepository extends GenericRepository<RoomDomain> implements IMemoryRoomRepository {
    public RoomRepository() {
        super("rooms.dat"); // Saves room data to rooms.dat
        if (storage.isEmpty()) {
            seedDefaultRooms();
        }
    }
    public void seedDefaultRooms() {
        create(new RoomDomain("101", RoomType.SINGLE, 50.0, 1, RoomStatus.AVAILABLE));
        create(new RoomDomain("102", RoomType.SINGLE, 50.0, 1, RoomStatus.AVAILABLE));
        create(new RoomDomain("103", RoomType.DOUBLE, 80.0, 2, RoomStatus.AVAILABLE));
        create(new RoomDomain("104", RoomType.DOUBLE, 80.0, 2, RoomStatus.BOOKED));
        create(new RoomDomain("201", RoomType.SUITE, 150.0, 4, RoomStatus.AVAILABLE));
        create(new RoomDomain("202", RoomType.SUITE, 150.0, 4, RoomStatus.AVAILABLE));
        create(new RoomDomain("203", RoomType.SINGLE, 55.0, 1, RoomStatus.AVAILABLE));
        create(new RoomDomain("204", RoomType.DOUBLE, 85.0, 2, RoomStatus.BOOKED));
        create(new RoomDomain("301", RoomType.DELUXE, 200.0, 3, RoomStatus.AVAILABLE));
        create(new RoomDomain("302", RoomType.DELUXE, 200.0, 3, RoomStatus.AVAILABLE));
    }
}

