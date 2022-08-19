package com.example.sportclub.model.responses;

public class EventLocationResponse {

    private Long id;
    private String address;
    private String description;
    private String email;
    private String name;
    private String phone;

    public EventLocationResponse() {
    }

    public EventLocationResponse(Long id, String address, String description, String email, String name, String phone) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
