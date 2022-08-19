package com.example.sportclub.model.requests;

public class TrainerEducationRequest {

    private String dateFrame;
    private String schoolName;
    private TrainerProfileRequest trainerProfile;

    public TrainerEducationRequest() {
    }

    public TrainerEducationRequest(String dateFrame, String schoolName, TrainerProfileRequest trainerProfile) {
        this.dateFrame = dateFrame;
        this.schoolName = schoolName;
        this.trainerProfile = trainerProfile;
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

    public TrainerProfileRequest getTrainerProfile() {
        return trainerProfile;
    }

    public void setTrainerProfile(TrainerProfileRequest trainerProfile) {
        this.trainerProfile = trainerProfile;
    }

    @Override
    public String toString() {
        return "TrainerEducationRequest{" +
                "dateFrame='" + dateFrame + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerEducationRequest that = (TrainerEducationRequest) o;

        if (dateFrame != null ? !dateFrame.equals(that.dateFrame) : that.dateFrame != null) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = dateFrame != null ? dateFrame.hashCode() : 0;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }
}
