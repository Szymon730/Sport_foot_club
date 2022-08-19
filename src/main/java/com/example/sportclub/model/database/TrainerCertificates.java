package com.example.sportclub.model.database;

import javax.persistence.*;

@Entity
public class TrainerCertificates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "trainerProfile_id")
    private TrainerProfile trainerProfile;

    public TrainerCertificates() {
    }

    public TrainerCertificates(final Long id, final String description, final TrainerProfile trainerProfile) {
        this.id = id;
        this.description = description;
        this.trainerProfile = trainerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "TrainerCertificates{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", trainerProfile=" + trainerProfile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerCertificates that = (TrainerCertificates) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return trainerProfile != null ? trainerProfile.equals(that.trainerProfile) : that.trainerProfile == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (trainerProfile != null ? trainerProfile.hashCode() : 0);
        return result;
    }
}
