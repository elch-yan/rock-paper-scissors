package com.elchyan.paperrockscissors.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
class ArtificialPlayerTest {
    @Test
    public void shouldGetRandomMove() {
        ArtificialPlayer player = new ArtificialPlayer("test");

        assertNotEquals(null, player.getMove());
    }
}