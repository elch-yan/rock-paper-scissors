package com.elchyan.paperrockscissors.players;


import com.elchyan.paperrockscissors.moves.Move;

import java.util.Random;

public class ArtificialPlayer extends SimplePlayer {
    private Random random = new Random();

    public ArtificialPlayer(String name) {
        super(name);
    }

    @Override
    public Move getMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
