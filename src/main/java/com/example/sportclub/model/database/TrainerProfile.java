package com.example.sportclub.model.database;


import javax.persistence.*;
import java.util.List;

@Entity
public class TrainerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String province;
    @OneToMany(mappedBy = "trainerProfile")
    private List<TrainerExperience> trainerExperiences;
    @OneToMany(mappedBy = "trainerProfile")
    private List<TrainerEducation> trainerEducations;
    @OneToMany(mappedBy = "trainerProfile")
    private List<TrainerCertificates> trainerCertificates;
    @OneToOne(cascade = CascadeType.ALL)
    private DAOUser user;

    public TrainerProfile() {
    }

    public TrainerProfile(final Long id, final String name, final String lastName, final String address, final String city, final String zipCode, final String province, final List<TrainerExperience> trainerExperiences, final List<TrainerEducation> trainerEducations, final List<TrainerCertificates> trainerCertificates, DAOUser user) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.province = province;
        this.trainerExperiences = trainerExperiences;
        this.trainerEducations = trainerEducations;
        this.trainerCertificates = trainerCertificates;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<TrainerExperience> getTrainerExperiences() {
        return trainerExperiences;
    }

    public void setTrainerExperiences(List<TrainerExperience> trainerExperiences) {
        this.trainerExperiences = trainerExperiences;
    }

    public List<TrainerEducation> getTrainerEducations() {
        return trainerEducations;
    }

    public void setTrainerEducations(List<TrainerEducation> trainerEducations) {
        this.trainerEducations = trainerEducations;
    }

    public List<TrainerCertificates> getTrainerCertificates() {
        return trainerCertificates;
    }

    public void setTrainerCertificates(List<TrainerCertificates> trainerCertificates) {
        this.trainerCertificates = trainerCertificates;
    }

    @Override
    public String toString() {
        return "TrainerProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerProfile that = (TrainerProfile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (trainerExperiences != null ? !trainerExperiences.equals(that.trainerExperiences) : that.trainerExperiences != null)
            return false;
        if (trainerEducations != null ? !trainerEducations.equals(that.trainerEducations) : that.trainerEducations != null)
            return false;
        return trainerCertificates != null ? trainerCertificates.equals(that.trainerCertificates) : that.trainerCertificates == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (trainerExperiences != null ? trainerExperiences.hashCode() : 0);
        result = 31 * result + (trainerEducations != null ? trainerEducations.hashCode() : 0);
        result = 31 * result + (trainerCertificates != null ? trainerCertificates.hashCode() : 0);
        return result;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}

