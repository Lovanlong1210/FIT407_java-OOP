package org.example;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private boolean isAvailable;
    private String roomType;
    private double pricePerNight;

    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.isAvailable = true; // Mặc định phòng là có sẵn khi tạo mới
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + "\n" +
                "Available: " + (isAvailable ? "Yes" : "No") + "\n" + // Hiển thị rõ ràng hơn
                "Room Type: " + roomType + "\n" +
                "Price per Night: " + pricePerNight + "\n" +
                "--------------------\n";
    }
}