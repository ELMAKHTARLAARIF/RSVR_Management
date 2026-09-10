package Domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String reservationCode;
    private UUID userId; // or String roomNumber
    private String roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numberOfGuests;
    private long numberOfNights;
    private BigDecimal totalPrice;
    private ReservationStatusDomain status;
    private LocalDateTime createdAt;

    public ReservationDomain(String roomNumber, LocalDate checkIn, LocalDate checkOut, int numberOfGuests, long numberOfNights, BigDecimal totalPrice, UUID userId) {
        this.id = UUID.randomUUID();
        this.reservationCode = "RES-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfGuests = numberOfGuests;
        this.numberOfNights = numberOfNights;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.status = ReservationStatusDomain.CONFIRMED;
        this.createdAt = LocalDateTime.now();
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(long numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getters
    public String getRoomNumber() { return roomNumber; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public ReservationStatusDomain getStatus() { return status; }
    public void setStatus(ReservationStatusDomain status) { this.status = status; }
}