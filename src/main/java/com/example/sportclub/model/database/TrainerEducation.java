package com.example.sportclub.model.database;

import javax.persistence.*;

@Entity
public class TrainerEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateFrame;
    private String schoolName;
    @ManyToOne
    @JoinColumn(name = "trainerProfile_id")
    private TrainerProfile trainerProfile;

    public TrainerEducation() {
    }

    public TrainerEducation(final Long id, final String dateFrame, final String schoolName, final TrainerProfile trainerProfile) {
        this.id = id;
        this.dateFrame = dateFrame;
        this.schoolName = schoolName;
        this.trainerProfile = trainerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TrainerProfile getTrainerProfile() {
        return trainerProfile;
    }

    public void setTrainerProfile(TrainerProfile trainerProfile) {
        this.trainerProfile = trainerProfile;
    }

    @Override
    public String toString() {
        return "TrainerEducation{" +
                "id=" + id +
                ", dateFrame='" + dateFrame + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerEducation that = (TrainerEducation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dateFrame != null ? !dateFrame.equals(that.dateFrame) : that.dateFrame != null) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateFrame != null ? dateFrame.hashCode() : 0);
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }
}
