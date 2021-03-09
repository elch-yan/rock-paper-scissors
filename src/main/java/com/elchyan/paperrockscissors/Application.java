package com.elchyan.paperrockscissors;

import com.elchyan.paperrockscissors.games.Game;
import com.elchyan.paperrockscissors.games.GameFactory;
import com.elchyan.paperrockscissors.games.GameTypes;

public class Application {
    public static void main(String[] args) {
        GameFactory factory = new GameFactory();
        Game game = factory.getGame(GameTypes.CMD_SINGLE_PLAYER);

        game.play();
    }
}
