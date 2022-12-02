package com.bhagya.research.business.destination.dto;

import java.util.List;

public class DestinationRequestDTO {
    private List<DestinationCategoryDTO> categories;
    private int durationOfStay;
    private int budget;

    public List<DestinationCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<DestinationCategoryDTO> categories) {
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
