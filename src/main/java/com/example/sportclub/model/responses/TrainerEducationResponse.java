package com.example.sportclub.model.responses;

public class TrainerEducationResponse {

    private String dateFrame;
    private String schoolName;

    public TrainerEducationResponse() {
    }

    public TrainerEducationResponse(String dateFrame, String schoolName) {
        this.dateFrame = dateFrame;
        this.schoolName = schoolName;
    }

    public String getDateFrame() {
        return dateFrame;
    }

    public void setDateFrame(String dateFrame) {
        this.dateFrame = dateFrame;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "TrainerEducationResponse{" +
                "dateFrame='" + dateFrame + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
