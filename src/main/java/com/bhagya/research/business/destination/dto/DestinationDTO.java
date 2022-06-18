package com.bhagya.research.business.destination.dto;

public class DestinationDTO {
    private String destinationName;
    private DestinationCategory destinationCategory1;
    private DestinationCategory destinationCategory2;
    private DestinationCategory destinationCategory3;
    private int destinationDurationToCover;
    private int destinationCost;
    private DestinationType destinationType;
    private float destinationLatitude;
    private float destinationLongitude;

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public DestinationCategory getDestinationCategory1() {
        return destinationCategory1;
    }

    public void setDestinationCategory1(DestinationCategory destinationCategory1) {
        this.destinationCategory1 = destinationCategory1;
    }

    public DestinationCategory getDestinationCategory2() {
        return destinationCategory2;
    }

    public void setDestinationCategory2(DestinationCategory destinationCategory2) {
        this.destinationCategory2 = destinationCategory2;
    }

    public DestinationCategory getDestinationCategory3() {
        return destinationCategory3;
    }

    public void setDestinationCategory3(DestinationCategory destinationCategory3) {
        this.destinationCategory3 = destinationCategory3;
    }

    public int getDestinationDurationToCover() {
        return destinationDurationToCover;
    }

    public void setDestinationDurationToCover(int destinationDurationToCover) {
        this.destinationDurationToCover = destinationDurationToCover;
    }

    public int getDestinationCost() {
        return destinationCost;
    }

    public void setDestinationCost(int destinationCost) {
        this.destinationCost = destinationCost;
    }

    public DestinationType getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(DestinationType destinationType) {
        this.destinationType = destinationType;
    }

    public float getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(float destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public float getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(float destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }
}
