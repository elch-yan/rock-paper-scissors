package com.elchyan.paperrockscissors.arbiters;

import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;

public interface GameOutcomeResolver {
    GameOutcome getResultForPlayerMove(Move playerMove, Move opponentMove);
}
