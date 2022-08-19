package com.example.sportclub.model.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private UUID eventCode;
    private String category;
    private LocalDateTime dateTime;
    private String description;
    @ManyToOne
    @JoinColumn(name = "eventLocation_id")
    private EventLocation eventLocation;
    private Integer teamSize;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<PlayerEvent> players;

    public Event() {
    }

    public Event(Long id, String category, LocalDateTime dateTime, String description, EventLocation eventLocation, Integer teamSize, Set<PlayerEvent> players) {
        this.id = id;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
        this.eventLocation = eventLocation;
        this.teamSize = teamSize;
        this.players = players;
        this.eventCode = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public Set<PlayerEvent> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEvent> players) {
        this.players = players;
    }

    public UUID getEventCode() {
        return eventCode;
    }

    public void setEventCode(UUID eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (eventCode != null ? !eventCode.equals(event.eventCode) : event.eventCode != null) return false;
        if (category != null ? !category.equals(event.category) : event.category != null) return false;
        if (dateTime != null ? !dateTime.equals(event.dateTime) : event.dateTime != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (eventLocation != null ? !eventLocation.equals(event.eventLocation) : event.eventLocation != null)
            return false;
        if (teamSize != null ? !teamSize.equals(event.teamSize) : event.teamSize != null) return false;
        return players != null ? players.equals(event.players) : event.players == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventCode != null ? eventCode.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (eventLocation != null ? eventLocation.hashCode() : 0);
        result = 31 * result + (teamSize != null ? teamSize.hashCode() : 0);
        result = 31 * result + (players != null ? players.hashCode() : 0);
        return result;
    }
}
