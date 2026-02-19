package com.hostel.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "room_id", length = 50, nullable = false)
    private String roomID;

    @Column(name = "room_type", nullable = false)
    private String roomType;

    @Column(name = "total_units", nullable = false)
    private int totalUnits;

    @Column(name = "occupied_units", nullable = false)
    private int occupiedUnits;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    // Getters and Setters
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public int getOccupiedUnits() {
        return occupiedUnits;
    }

    public void setOccupiedUnits(int occupiedUnits) {
        this.occupiedUnits = occupiedUnits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [roomID=" + roomID + ", roomType=" + roomType + 
               ", totalUnits=" + totalUnits + ", occupiedUnits=" + occupiedUnits + 
               ", capacity=" + capacity + "]";
    }
}
