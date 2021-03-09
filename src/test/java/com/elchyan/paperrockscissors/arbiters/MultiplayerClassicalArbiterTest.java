package com.elchyan.paperrockscissors.arbiters;

import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.players.ArtificialPlayer;
import com.elchyan.paperrockscissors.players.Player;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplayerClassicalArbiterTest {
    private GameArbiter arbiter = new MultiplayerClassicalArbiter(new ClassicalGameOutcomeResolver());

    @Test
    public void shouldThrowErrorOnNull() {
        assertThrows(IllegalArgumentException.class, () -> arbiter.judge(null));
    }

    @Test
    public void shouldThrowErrorOnEmptyMap() {
        assertThrows(IllegalArgumentException.class, () -> arbiter.judge(Collections.emptyMap()));
    }

    @Test
    public void shouldThrowErrorOnSingleMapElement() {
        assertThrows(IllegalArgumentException.class, () -> arbiter.judge(Collections.singletonMap(new ArtificialPlayer("test"), Move.ROCK)));
    }

    @Test
    public void shouldReturnDrawForSameMoveForTwoPlayers() {
        Player p1 = new ArtificialPlayer("test1");
        Player p2 = new ArtificialPlayer("test2");
        Map<Player, Move> pm = new HashMap<>(){{
            put(p1, Move.PAPER);
            put(p2, Move.PAPER);
        }};

        Map<Player, GameOutcome> po = arbiter.judge(pm);

        assertEquals(GameOutcome.DRAW, po.get(p1));
        assertEquals(GameOutcome.DRAW, po.get(p2));
    }

    @Test
    public void shouldReturnDrawForSameMoveForMultiplePlayers() {
        Player p1 = new ArtificialPlayer("test1");
        Player p2 = new ArtificialPlayer("test2");
        Player p3 = new ArtificialPlayer("test3");
        Map<Player, Move> pm = new HashMap<>(){{
            put(p1, Move.SCISSORS);
            put(p2, Move.SCISSORS);
            put(p3, Move.SCISSORS);
        }};

        Map<Player, GameOutcome> po = arbiter.judge(pm);

        assertEquals(GameOutcome.DRAW, po.get(p1));
        assertEquals(GameOutcome.DRAW, po.get(p2));
        assertEquals(GameOutcome.DRAW, po.get(p3));
    }

    @Test
    public void shouldReturnDrawForMultiplePlayersWithDifferentMoves() {
        Player p1 = new ArtificialPlayer("test1");
        Player p2 = new ArtificialPlayer("test2");
        Player p3 = new ArtificialPlayer("test3");
        Player p4 = new ArtificialPlayer("test3");
        Map<Player, Move> pm = new HashMap<>(){{
            put(p1, Move.SCISSORS);
            put(p2, Move.ROCK);
            put(p3, Move.SCISSORS);
            put(p4, Move.PAPER);
        }};

        Map<Player, GameOutcome> po = arbiter.judge(pm);

        assertEquals(GameOutcome.DRAW, po.get(p1));
        assertEquals(GameOutcome.DRAW, po.get(p2));
        assertEquals(GameOutcome.DRAW, po.get(p3));
        assertEquals(GameOutcome.DRAW, po.get(p3));
    }

    @Test
    public void shouldReturnWinLossForTwoPlayers() {
        Player p1 = new ArtificialPlayer("test1");
        Player p2 = new ArtificialPlayer("test2");
        Map<Player, Move> pm = new HashMap<>(){{
            put(p1, Move.PAPER);
            put(p2, Move.SCISSORS);
        }};

        Map<Player, GameOutcome> po = arbiter.judge(pm);

        assertEquals(GameOutcome.LOSS, po.get(p1));
        assertEquals(GameOutcome.WIN, po.get(p2));
    }

    @Test
    public void shouldReturnWinLossForMultiplePlayers() {
        Player p1 = new ArtificialPlayer("test1");
        Player p2 = new ArtificialPlayer("test2");
        Player p3 = new ArtificialPlayer("test3");
        Player p4 = new ArtificialPlayer("test3");
        Map<Player, Move> pm = new HashMap<>(){{
            put(p1, Move.SCISSORS);
            put(p2, Move.ROCK);
            put(p3, Move.SCISSORS);
            put(p4, Move.ROCK);
        }};

        Map<Player, GameOutcome> po = arbiter.judge(pm);

        assertEquals(GameOutcome.LOSS, po.get(p1));
        assertEquals(GameOutcome.WIN, po.get(p2));
        assertEquals(GameOutcome.LOSS, po.get(p3));
        assertEquals(GameOutcome.WIN, po.get(p4));
    }
}