package Services;

import Domains.RoomDomain;
import Repositories.Implementation.IGenericRepository;

public class RoomService {
    private  final IGenericRepository<RoomDomain> roomRepository;
    public RoomService(IGenericRepository<RoomDomain> roomRepository ) {
        this.roomRepository = roomRepository;
    }

    public void CreateRoom(){

    }
}
