package com.elchyan.paperrockscissors.players;


import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;

public interface Player {
    String getName();

    Move getMove();

    void resultHandler(GameOutcome o);

    int getScore();
}
