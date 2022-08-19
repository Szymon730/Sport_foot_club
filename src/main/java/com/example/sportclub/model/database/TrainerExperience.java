package com.example.sportclub.model.database;

import javax.persistence.*;

@Entity
public class TrainerExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateFrame;
    private String workLocation;
    private String description;
    @ManyToOne
    @JoinColumn(name = "trainerProfile_id")
    private TrainerProfile trainerProfile;

    public TrainerExperience() {
    }

    public TrainerExperience(final Long id, final String dateFrame, final String workLocation, final String description, final TrainerProfile trainerProfile) {
        this.id = id;
        this.dateFrame = dateFrame;
        this.workLocation = workLocation;
        this.description = description;
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

    public TrainerProfile getTrainerProfile() {
        return trainerProfile;
    }

    public void setTrainerProfile(TrainerProfile trainerProfile) {
        this.trainerProfile = trainerProfile;
    }

    @Override
    public String toString() {
        return "TrainerExperience{" +
                "id=" + id +
                ", dateFrame='" + dateFrame + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", description='" + description + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerExperience that = (TrainerExperience) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dateFrame != null ? !dateFrame.equals(that.dateFrame) : that.dateFrame != null) return false;
        if (workLocation != null ? !workLocation.equals(that.workLocation) : that.workLocation != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateFrame != null ? dateFrame.hashCode() : 0);
        result = 31 * result + (workLocation != null ? workLocation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }

}
