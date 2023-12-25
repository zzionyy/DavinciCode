package com.dk.davinci.model.dto;

import com.dk.davinci.model.GameStatus;

public class GameRoom {
    private User host;

    private User guest;
    private GameStatus gameStatus;

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return "GameRoom{" +
                "host=" + host +
                ", guest=" + guest +
                ", gameStatus=" + gameStatus +
                '}';
    }
}
