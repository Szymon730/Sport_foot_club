package com.example.sportclub.model.requests;

public class TrainerCertificatesRequest {

    private String description;
    private TrainerProfileRequest trainerProfile;

    public TrainerCertificatesRequest() {
    }

    public TrainerCertificatesRequest(String description, TrainerProfileRequest trainerProfile) {
        this.description = description;
        this.trainerProfile = trainerProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainerProfileRequest getTrainerProfile() {
        return trainerProfile;
    }

    public void setTrainerProfile(TrainerProfileRequest trainerProfile) {
        this.trainerProfile = trainerProfile;
    }

    @Override
    public String toString() {
        return "TrainerCertificatesRequest{" +
                "description='" + description + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerCertificatesRequest that = (TrainerCertificatesRequest) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }
}
