package com.booking.slotbooking.dto;


/**
 * @Author Allan George
 */
public class PartnerRequestDTO {

    private String name;
    private String city;
    private Boolean available;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}