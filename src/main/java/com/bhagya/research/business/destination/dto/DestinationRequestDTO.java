package com.bhagya.research.business.destination.dto;

import java.util.List;

public class DestinationRequestDTO {
    private List<DestinationCategory> categories;
    private int durationOfStay;
    private int budget;

    public List<DestinationCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<DestinationCategory> categories) {
        this.categories = categories;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
