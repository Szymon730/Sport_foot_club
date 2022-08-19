package com.example.sportclub.model.responses;


import java.util.List;

public class TrainerProfileResponse {

    private String name;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String province;
    private List<TrainerExperienceResponse> trainerExperiences;
    private List<TrainerEducationResponse> trainerEducations;
    private List<TrainerCertificatesResponse> trainerCertificates;

    public TrainerProfileResponse() {
    }

    public TrainerProfileResponse(String name, String lastName, String address, String city, String zipCode, String province, List<TrainerExperienceResponse> trainerExperiences, List<TrainerEducationResponse> trainerEducations, List<TrainerCertificatesResponse> trainerCertificates) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.province = province;
        this.trainerExperiences = trainerExperiences;
        this.trainerEducations = trainerEducations;
        this.trainerCertificates = trainerCertificates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<TrainerExperienceResponse> getTrainerExperiences() {
        return trainerExperiences;
    }

    public void setTrainerExperiences(List<TrainerExperienceResponse> trainerExperiences) {
        this.trainerExperiences = trainerExperiences;
    }

    public List<TrainerEducationResponse> getTrainerEducations() {
        return trainerEducations;
    }

    public void setTrainerEducations(List<TrainerEducationResponse> trainerEducations) {
        this.trainerEducations = trainerEducations;
    }

    public List<TrainerCertificatesResponse> getTrainerCertificates() {
        return trainerCertificates;
    }

    public void setTrainerCertificates(List<TrainerCertificatesResponse> trainerCertificates) {
        this.trainerCertificates = trainerCertificates;
    }

    @Override
    public String toString() {
        return "TrainerProfileResponse{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", province='" + province + '\'' +
                ", trainerExperiences=" + trainerExperiences +
                ", trainerEducations=" + trainerEducations +
                ", trainerCertificates=" + trainerCertificates +
                '}';
    }

}

