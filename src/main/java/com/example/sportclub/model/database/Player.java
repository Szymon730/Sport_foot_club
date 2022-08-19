package com.example.sportclub.model.database;

import com.example.sportclub.model.enums.PlayerStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    private String lastName;
    private String birthDate;
    private String position;
    @Enumerated(EnumType.STRING)
    private PlayerStatus playerStatus;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayerEvent> events;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private DAOUser user;

    public Player() {
    }

    public Player(String name, String lastName, String birthDate, String email, String position, PlayerStatus playerStatus, Set<PlayerEvent> events) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.position = position;
        this.playerStatus = playerStatus;
        this.events = events;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != null ? !id.equals(player.id) : player.id != null) return false;
        if (email != null ? !email.equals(player.email) : player.email != null) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (lastName != null ? !lastName.equals(player.lastName) : player.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(player.birthDate) : player.birthDate != null) return false;
        if (position != null ? !position.equals(player.position) : player.position != null) return false;
        if (playerStatus != player.playerStatus) return false;
        return events != null ? events.equals(player.events) : player.events == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (playerStatus != null ? playerStatus.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", position='" + position + '\'' +
                ", playerStatus=" + playerStatus +
                '}';
    }

    public Set<PlayerEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<PlayerEvent> events) {
        this.events = events;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}
