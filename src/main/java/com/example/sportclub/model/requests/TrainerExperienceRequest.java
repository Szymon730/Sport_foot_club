package com.example.sportclub.model.requests;

public class TrainerExperienceRequest {

    private String dateFrame;
    private String workLocation;
    private String description;
    private TrainerProfileRequest trainerProfile;

    public TrainerExperienceRequest() {
    }

    public TrainerExperienceRequest(String dateFrame, String workLocation, String description, TrainerProfileRequest trainerProfile) {
        this.dateFrame = dateFrame;
        this.workLocation = workLocation;
        this.description = description;
        this.trainerProfile = trainerProfile;
    }

    public String getDateFrame() {
        return dateFrame;
    }

    public void setDateFrame(String dateFrame) {
        this.dateFrame = dateFrame;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
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
        return "TrainerExperienceRequest{" +
                "dateFrame='" + dateFrame + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", description='" + description + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerExperienceRequest that = (TrainerExperienceRequest) o;

        if (dateFrame != null ? !dateFrame.equals(that.dateFrame) : that.dateFrame != null) return false;
        if (workLocation != null ? !workLocation.equals(that.workLocation) : that.workLocation != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = dateFrame != null ? dateFrame.hashCode() : 0;
        result = 31 * result + (workLocation != null ? workLocation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }

}
