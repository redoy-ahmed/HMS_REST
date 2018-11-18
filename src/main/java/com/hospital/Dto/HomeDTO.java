package com.hospital.Dto;

public class HomeDTO {

    private int noOfAllotedBeds;
    private int noOfReportsToBeDelivered;
    private int noOfAvailableBloodBags;


    public int getNoOfAllotedBeds() {
        return noOfAllotedBeds;
    }

    public void setNoOfAllotedBeds(int noOfAllotedBeds) {
        this.noOfAllotedBeds = noOfAllotedBeds;
    }

    public int getNoOfReportsToBeDelivered() {
        return noOfReportsToBeDelivered;
    }

    public void setNoOfReportsToBeDelivered(int noOfReportsToBeDelivered) {
        this.noOfReportsToBeDelivered = noOfReportsToBeDelivered;
    }

    public int getNoOfAvailableBloodBags() {
        return noOfAvailableBloodBags;
    }

    public void setNoOfAvailableBloodBags(int noOfAvailableBloodBags) {
        this.noOfAvailableBloodBags = noOfAvailableBloodBags;
    }
}
