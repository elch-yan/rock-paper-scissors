package com.elchyan.paperrockscissors.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameFactoryTest {
    @Test
    public void shouldReturnCMDSinglePlayerGameInstance() {
        GameFactory factory = new GameFactory();
        Game game = factory.getGame(GameTypes.CMD_SINGLE_PLAYER);

        assertTrue(game instanceof CmdSinglePlayerGame);
    }
}