package com.elchyan.paperrockscissors.players;

import com.elchyan.paperrockscissors.games.GameOutcome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplePlayerTest {
    private ArtificialPlayer player;

    @BeforeEach
    public void beforeEach() {
        player = new ArtificialPlayer("test");
    }

    @Test
    public void initialScoreShouldBeZero() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void shouldNotUpdateScoreOnLoss() {
        int initial = player.getScore();

        player.resultHandler(GameOutcome.LOSS);

        assertEquals(initial, player.getScore());
    }

    @Test
    public void shouldNotUpdateScoreOnDraw() {
        int initial = player.getScore();

        player.resultHandler(GameOutcome.DRAW);

        assertEquals(initial, player.getScore());
    }

    @Test
    public void shouldUpdateScoreOnWin() {
        int initial = player.getScore();

        player.resultHandler(GameOutcome.WIN);
        player.resultHandler(GameOutcome.WIN);

        assertEquals(initial + 2, player.getScore());
    }
}