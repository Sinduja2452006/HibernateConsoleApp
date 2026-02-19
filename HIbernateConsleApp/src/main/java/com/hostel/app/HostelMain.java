package com.hostel.app;

import com.hostel.service.HostelService;

public class HostelMain {

    public static void main(String[] args) {

        HostelService hostelService = new HostelService();

        System.out.println("--- Hostel Allocation Console ---");


        int allocationID = hostelService.allocateStudent(
                "R001",
                "ST9999",
                "Vinay Kumar"
        );

        if (allocationID != -1) {
            System.out.println("ALLOCATED with ID: " + allocationID);

            boolean vacated = hostelService.vacateStudent(allocationID);
            System.out.println(vacated ? "VACATED" : "FAILED");
        } else {
            System.out.println("FAILED");
        }
    }
}
