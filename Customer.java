package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String roomNeeded;
    private List<Integer> bookedRooms;

    public Customer(int id, String name, String address, String phoneNumber, String birthDate, String roomNeeded) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.roomNeeded = roomNeeded;
        this.bookedRooms = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<Integer> getBookedRooms() { return bookedRooms; }
    public void addBookedRoom(int roomNumber) { bookedRooms.add(roomNumber); }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getRoomNeeded() {
        return roomNeeded;
    }

    public void setRoomNeeded(String roomNeeded) {
        this.roomNeeded = roomNeeded;
    }
}