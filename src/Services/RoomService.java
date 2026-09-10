package Services;

import Domains.RoomDomain;
import Domains.RoomStatus;
import Repositories.Implementation.IGenericRepository;
import Repositories.RoomRepository;

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

    public List<RoomDomain> searchAviableRooms(){
        ArrayList<RoomDomain> AvialableRooms = new ArrayList<>();
        for (RoomDomain room: roomRepository.getAll()){
            if(room.getStatus() == RoomStatus.AVAILABLE){
                AvialableRooms.add(room);
            }
        }
        return AvialableRooms;

    }
}
