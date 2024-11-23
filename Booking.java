package org.example;

public class Booking {
    private final int bookingId; // Mã đặt phòng
    private final int customerId; // Mã khách hàng
    private final String roomType; // Loại phòng
    private final String checkInDate; // Ngày nhận phòng
    private final String checkOutDate; // Ngày trả phòng

    public Booking(int bookingId, int customerId, String roomType, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getter và Setter cho các thuộc tính
    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
}
