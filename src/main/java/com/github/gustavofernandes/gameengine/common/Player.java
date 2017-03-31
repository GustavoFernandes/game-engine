package com.github.gustavofernandes.gameengine.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

public class Player<T extends Team> implements Observer {

    protected Game game;

    private UUID id;
    private T team;

    public Player() {
        this.id = UUID.randomUUID();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTeam(T team) {
        this.team = team;
    }

    public T getTeam() {
        return this.team;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Player otherPlayer = (Player) obj;
        return new EqualsBuilder()
                .append(this.id, otherPlayer.id)
                .append(this.team, otherPlayer.team)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 11)
                .append(this.team)
                .toHashCode();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.update((State) arg);
    }

    public <U extends State> void update(U state){
        // TODO abstract this
    };
}
