package com.example.sportclub.model.database;

import com.example.sportclub.model.database.key.PlayerEventKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PlayerEvent {

    @EmbeddedId
    private PlayerEventKey id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

    private boolean confirmed;

    public PlayerEvent() {
    }

    public PlayerEvent(PlayerEventKey id, Player player, Event event) {
        this.id = id;
        this.player = player;
        this.event = event;
    }

    public PlayerEventKey getId() {
        return id;
    }

    public void setId(PlayerEventKey id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
