package com.example.sportclub.model.database.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlayerEventKey implements Serializable {

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "event_id")
    private Long eventId;

    public PlayerEventKey() {
    }

    public PlayerEventKey(Long playerId, Long eventId) {
        this.playerId = playerId;
        this.eventId = eventId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEventKey that = (PlayerEventKey) o;

        if (playerId != null ? !playerId.equals(that.playerId) : that.playerId != null) return false;
        return eventId != null ? eventId.equals(that.eventId) : that.eventId == null;
    }

    @Override
    public int hashCode() {
        int result = playerId != null ? playerId.hashCode() : 0;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        return result;
    }
}
