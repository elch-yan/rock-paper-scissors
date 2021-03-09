package com.elchyan.paperrockscissors.players;


import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.moves.inputproviders.MoveInputProvider;

public class RealPlayer extends SimplePlayer {
    private MoveInputProvider provider;

    public RealPlayer(String name, MoveInputProvider provider) {
        super(name);
        this.provider = provider;
    }

    @Override
    public Move getMove() {
        return provider.requestMove(this);
    }
}
