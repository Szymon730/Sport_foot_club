package com.example.sportclub.model.responses;

public class TrainerCertificatesResponse {

    private String description;

    public TrainerCertificatesResponse() {
    }

    public TrainerCertificatesResponse(final String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TrainerCertificatesResponse{" +
                "description='" + description + '\'' +
                '}';
    }

}
