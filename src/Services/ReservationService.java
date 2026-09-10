package Services;

import Domains.ReservationDomain;
import Domains.ReservationStatusDomain;
import Domains.RoomDomain;
import Repositories.GenericRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ReservationService {
    private final GenericRepository<ReservationDomain> reservationRepository;
    private final GenericRepository<RoomDomain> roomRepository;

    public ReservationService(GenericRepository<ReservationDomain> reservationRepository, GenericRepository<RoomDomain> roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public boolean makeReservation(String roomNumber, LocalDate checkIn, LocalDate checkOut, int numberOfGuests, UUID userId) {
        // Validate dates checkOut before CheckIn
        if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
            System.out.println("Error: Check-out date must be after check-in date.");
            return false;
        }
        // CheckIn before now date
        if (checkIn.isBefore(LocalDate.now())) {
            System.out.println("Error: Cannot book a room in the past.");
            return false;
        }

        // Find the room
        RoomDomain targetRoom = null;
        for (RoomDomain room : roomRepository.getAll()) {
            if (room.getRoomNumber().equals(roomNumber)) {
                targetRoom = room;
                break;
            }
        }

        if (targetRoom == null) {
            System.out.println("Error: Room " + roomNumber + " does not exist.");
            return false;
        }

        // Check capacity
        if (numberOfGuests > targetRoom.getCapacity()) {
            System.out.println("Error: Room capacity is " + targetRoom.getCapacity() + ", but you requested for " + numberOfGuests + " guests.");
            return false;
        }

        for (ReservationDomain res : reservationRepository.getAll()) {
            if (res.getRoomNumber().equals(roomNumber) && res.getStatus() == ReservationStatusDomain.CONFIRMED) {

                boolean isOverlapping = !(checkOut.isBefore(res.getCheckIn()) || checkOut.isEqual(res.getCheckIn()) ||
                        checkIn.isAfter(res.getCheckOut()) || checkIn.isEqual(res.getCheckOut()));
                if (isOverlapping) {
                    System.out.println("Error: Room " + roomNumber + " is already booked from " + res.getCheckIn() + " to " + res.getCheckOut());
                    return false;
                }
            }
        }


        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        BigDecimal totalPrice = BigDecimal.valueOf(targetRoom.getPricePerNight() * nights);


        ReservationDomain newReservation = new ReservationDomain(roomNumber, checkIn, checkOut, numberOfGuests, nights, totalPrice, userId);
        reservationRepository.create(newReservation);

        System.out.println("Success! Reservation created. Total Price: $" + totalPrice + " for " + nights + " nights."+userId);
        return true;
    }

    public List<ReservationDomain> MyReservations(UUID user_id){
        List<ReservationDomain> MyReservations = new ArrayList<>();
        for (ReservationDomain reserv : reservationRepository.getAll()){
            if (reserv.getUserId().equals(user_id)){
                MyReservations.add(reserv);
            }
        }
        return MyReservations;
    }
    public ReservationDomain CancelResservation(String reservationCode){
        for(ReservationDomain rv : reservationRepository.getAll()){
            if(rv.getReservationCode().equals(reservationCode)){
                rv.setStatus(ReservationStatusDomain.CANCELLED);
                System.out.println("Reservation " + reservationCode + " has been cancelled.");
                return rv;
            }
        }
        return null;
    }
}