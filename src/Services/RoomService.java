package Services;

import Domains.RoomDomain;
import Repositories.Implementation.IGenericRepository;
import java.util.List;
import java.util.ArrayList;
public class RoomService {
    private  final IGenericRepository<RoomDomain> roomRepository;
    public RoomService(IGenericRepository<RoomDomain> roomRepository ) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDomain> getAllRooms() {
        return roomRepository.getAll();
    }
}
