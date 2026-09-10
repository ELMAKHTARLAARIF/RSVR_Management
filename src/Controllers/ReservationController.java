package Controllers;

import Domains.ReservationDomain;
import Services.ReservationService;
import com.sun.source.doctree.EscapeTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ReservationController {
    public final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    public void makeReservation(Scanner scanner, UUID currentUserId) {
        System.out.println("------ Make a Reservation --------");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            System.out.print("Check-in Date (YYYY-MM-DD): ");
            LocalDate checkIn = LocalDate.parse(scanner.nextLine().trim(), dateFormatter);

            System.out.print("Check-out Date (YYYY-MM-DD): ");
            LocalDate checkOut = LocalDate.parse(scanner.nextLine().trim(), dateFormatter);

            System.out.print("Number Of Guests: ");
            int numberOfGuests = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Room Number: ");
            String roomNumber = scanner.nextLine().trim();

            reservationService.makeReservation(roomNumber, checkIn, checkOut, numberOfGuests, currentUserId);

        } catch (Exception e) {
            System.out.println("Invalid Input Format. Please try again. Error: " + e.getMessage());
        }
    }
    public void MyReservations(UUID user_id){
      List<ReservationDomain> UserResevations = reservationService.MyReservations(user_id);
      if (UserResevations.isEmpty()){
          System.out.println("Any Reservation For You!!!");
          return;
      }
      for (ReservationDomain ur: UserResevations){
          System.out.println("Status: "+ur.getStatus()+"   Number Of Room: "+ur.getRoomNumber()+"  Checkin: "+ur.getCheckIn()+"  CheckOut: "+ur.getCheckOut()+"   Number Of Nights: "+ur.getNumberOfNights()+"   Total Price: "+ur.getTotalPrice()+"$"+"Reservation Code: "+ur.getReservationCode());
      }
    }
    public void cancelReservation(Scanner scanner) {
        System.out.println("------ Cancel Reservation --------");
        System.out.print("Enter Reservation Code (e.g., RES-XYZ123): ");
        String reservationCode = scanner.nextLine().trim();

        reservationService.CancelResservation(reservationCode);
    }
}