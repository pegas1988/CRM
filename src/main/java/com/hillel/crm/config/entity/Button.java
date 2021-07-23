package com.hillel.crm.config.entity;

public class Button extends BaseEntity{
    private String buttonForNavbar;

    public Button() {
    }

    public String getButtonForNavbar() {
        return buttonForNavbar;
    }

    public void setButtonForNavbar(String buttonForNavbar) {
        this.buttonForNavbar = buttonForNavbar;
    }

    public Button(String buttonForNavbar) {
        this.buttonForNavbar = buttonForNavbar;
    }
}
