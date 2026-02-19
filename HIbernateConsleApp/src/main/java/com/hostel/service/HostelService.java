package com.hostel.service;

import com.hostel.bean.Allocation;
import com.hostel.bean.Room;
import com.hostel.dao.AllocationDAO;
import com.hostel.dao.RoomDAO;

import java.time.LocalDateTime;

public class HostelService {

    private RoomDAO roomDAO = new RoomDAO();
    private AllocationDAO allocationDAO = new AllocationDAO();

    public int allocateStudent(String roomID, String studentID, String studentName) {

        Room room = roomDAO.findRoom(roomID);

        if (room == null) {
            System.out.println("Room does not exist");
            return -1;
        }

        if (room.getOccupiedUnits() >= room.getCapacity()) {
            System.out.println("Room is full");
            return -1;
        }

        Allocation allocation = new Allocation();
        allocation.setRoomID(roomID);
        allocation.setStudentID(studentID);
        allocation.setStudentName(studentName);
        allocation.setAllocateDate(LocalDateTime.now());

        int generatedID = allocationDAO.insertAllocation(allocation);

        if (generatedID != -1) {
            room.setOccupiedUnits(room.getOccupiedUnits() + 1);
            roomDAO.updateRoom(room);
        }

        return generatedID;
    }

    public boolean vacateStudent(int allocationID) {

        Allocation allocation = allocationDAO.findAllocation(allocationID);

        if (allocation == null) {
            System.out.println("Allocation not found");
            return false;
        }

        allocation.setVacateDate(LocalDateTime.now());

        boolean updated = allocationDAO.updateAllocation(allocation);

        if (updated) {
            Room room = roomDAO.findRoom(allocation.getRoomID());
            room.setOccupiedUnits(room.getOccupiedUnits() - 1);
            roomDAO.updateRoom(room);
        }

        return updated;
    }
}
