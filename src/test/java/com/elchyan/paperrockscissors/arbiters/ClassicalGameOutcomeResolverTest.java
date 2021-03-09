package com.elchyan.paperrockscissors.arbiters;

import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClassicalGameOutcomeResolverTest {
    private ClassicalGameOutcomeResolver outcomeResolver = new ClassicalGameOutcomeResolver();

    @Test
    public void sameMovesShouldResultInDraw() {
        assertEquals(GameOutcome.DRAW, outcomeResolver.getResultForPlayerMove(Move.ROCK, Move.ROCK));
        assertEquals(GameOutcome.DRAW, outcomeResolver.getResultForPlayerMove(Move.PAPER, Move.PAPER));
        assertEquals(GameOutcome.DRAW, outcomeResolver.getResultForPlayerMove(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    public void rockShouldBeatScissors() {
        assertEquals(GameOutcome.WIN, outcomeResolver.getResultForPlayerMove(Move.ROCK, Move.SCISSORS));
    }

    @Test
    public void rockShouldLoseToPaper() {
        assertEquals(GameOutcome.LOSS, outcomeResolver.getResultForPlayerMove(Move.ROCK, Move.PAPER));
    }

    @Test
    public void paperShouldBeatRock() {
        assertEquals(GameOutcome.WIN, outcomeResolver.getResultForPlayerMove(Move.PAPER, Move.ROCK));
    }

    @Test
    public void paperShouldLoseToScissors() {
        assertEquals(GameOutcome.LOSS, outcomeResolver.getResultForPlayerMove(Move.PAPER, Move.SCISSORS));
    }

    @Test
    public void scissorsShouldBeatPaper() {
        assertEquals(GameOutcome.WIN, outcomeResolver.getResultForPlayerMove(Move.SCISSORS, Move.PAPER));
    }

    @Test
    public void scissorsShouldLoseToRock() {
        assertEquals(GameOutcome.LOSS, outcomeResolver.getResultForPlayerMove(Move.SCISSORS, Move.ROCK));
    }

    @Test
    public void shouldThrowExceptionIfOneOfArgumentsIsNull() {
        assertThrows(IllegalArgumentException.class, () -> outcomeResolver.getResultForPlayerMove(Move.ROCK, null));
    }
}