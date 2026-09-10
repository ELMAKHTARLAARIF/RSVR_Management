package Repositories;

import Repositories.Implementation.IGenericRepository;
import Repositories.Implementation.IMemoryReservationRepository;

public class ReservationRepository extends GenericRepository implements IMemoryReservationRepository {

    public ReservationRepository(){
        super("reservation.dat");
    }
}
