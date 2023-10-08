package com.bhagya.research.core.dto;

public class ImageButtonDTO {
    private String title;
    private String icon;
    private boolean isDisabled;
    private boolean isHidden;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ImageButtonDTO(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }
}
