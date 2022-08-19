package com.example.sportclub.model.requests;

public class AddNewEventLocationRequest {

    private String address;
    private String description;
    private String email;
    private String name;
    private String phone;

    public AddNewEventLocationRequest() {
    }

    public AddNewEventLocationRequest(String address, String description, String email, String name, String phone) {
        this.address = address;
        this.description = description;
        this.email = email;
        this.name = name;
        this.phone = phone;
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
