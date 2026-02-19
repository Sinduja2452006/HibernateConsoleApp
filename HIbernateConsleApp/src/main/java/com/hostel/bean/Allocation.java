package com.hostel.bean;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "allocations")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocationid")
    private int allocationID;

    @Column(name = "room_id", nullable = false)
    private String roomID;

    @Column(name = "student_id", nullable = false)
    private String studentID;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "allocate_date")
    private LocalDateTime allocateDate;

    @Column(name = "vacate_date")
    private LocalDateTime vacateDate;

    // Getters & Setters

    public int getAllocationID() {
        return allocationID;
    }

    public void setAllocationID(int allocationID) {
        this.allocationID = allocationID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getAllocateDate() {
        return allocateDate;
    }

    public void setAllocateDate(LocalDateTime allocateDate) {
        this.allocateDate = allocateDate;
    }

    public LocalDateTime getVacateDate() {
        return vacateDate;
    }

    public void setVacateDate(LocalDateTime vacateDate) {
        this.vacateDate = vacateDate;
    }
}
