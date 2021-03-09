package com.elchyan.paperrockscissors.players;

import com.elchyan.paperrockscissors.games.GameOutcome;

public abstract class SimplePlayer implements Player {
    private String name;

    private int score = 0;

    public SimplePlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void resultHandler(GameOutcome o) {
        if (o == GameOutcome.WIN)
            score++;
    }

    @Override
    public int getScore() {
        return score;
    }
}
