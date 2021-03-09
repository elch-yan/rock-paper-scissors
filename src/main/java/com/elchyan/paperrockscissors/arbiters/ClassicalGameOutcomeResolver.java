package com.elchyan.paperrockscissors.arbiters;

import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;


public class ClassicalGameOutcomeResolver implements GameOutcomeResolver {
    @Override
    public GameOutcome getResultForPlayerMove(Move playerMove, Move opponentMove) {
        checkForIllegalArguments(playerMove, opponentMove);
        if (playerMove == opponentMove)
            return GameOutcome.DRAW;

        if (playerMove == Move.ROCK)
            return getResultForRock(opponentMove);

        if (playerMove == Move.PAPER)
            return getResultForPaper(opponentMove);

        return getResultForScissors(opponentMove);
    }

    private void checkForIllegalArguments(Move m1, Move m2) {
        if (m1 == null || m2 == null)
            throw new IllegalArgumentException("You should pass valid moves");
    }

    private GameOutcome getResultForRock(Move opponentMove) {
        if (opponentMove == Move.PAPER)
            return GameOutcome.LOSS;

        return GameOutcome.WIN;
    }

    private GameOutcome getResultForPaper(Move opponentMove) {
        if (opponentMove == Move.ROCK)
            return GameOutcome.WIN;

        return GameOutcome.LOSS;
    }

    private GameOutcome getResultForScissors(Move opponentMove) {
        if (opponentMove == Move.ROCK)
            return GameOutcome.LOSS;

        return GameOutcome.WIN;
    }
}
