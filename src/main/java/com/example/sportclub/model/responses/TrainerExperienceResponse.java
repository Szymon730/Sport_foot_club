package com.example.sportclub.model.responses;

public class TrainerExperienceResponse {

    private String dateFrame;
    private String workLocation;
    private String description;

    public TrainerExperienceResponse() {
    }

    public TrainerExperienceResponse(String dateFrame, String workLocation, String description) {
        this.dateFrame = dateFrame;
        this.workLocation = workLocation;
        this.description = description;
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

    @Override
    public String toString() {
        return "TrainerExperienceResponse{" +
                "dateFrame='" + dateFrame + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
