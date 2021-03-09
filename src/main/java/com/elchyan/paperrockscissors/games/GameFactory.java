package com.elchyan.paperrockscissors.games;

import com.elchyan.paperrockscissors.arbiters.ClassicalGameOutcomeResolver;
import com.elchyan.paperrockscissors.arbiters.GameArbiter;
import com.elchyan.paperrockscissors.arbiters.MultiplayerClassicalArbiter;
import com.elchyan.paperrockscissors.moves.MoveInterpreter;
import com.elchyan.paperrockscissors.moves.TextMoveInterpreter;
import com.elchyan.paperrockscissors.moves.inputproviders.CmdMoveInputProvider;
import com.elchyan.paperrockscissors.moves.inputproviders.MoveInputProvider;

import java.util.Scanner;

public class GameFactory {
    public Game getGame(GameTypes type) {
        switch(type) {
            case CMD_SINGLE_PLAYER:
                return createCmdSinglePlayerGame();
            default:
                throw new IllegalArgumentException("Invalid game name");
        }
    }

    private Game createCmdSinglePlayerGame() {
        Scanner sc = new Scanner(System.in);
        GameArbiter arbiter = new MultiplayerClassicalArbiter(new ClassicalGameOutcomeResolver());

        MoveInterpreter<String> interpreter = new TextMoveInterpreter();
        MoveInputProvider inputProvider = new CmdMoveInputProvider(sc, interpreter);

        return new CmdSinglePlayerGame(sc, arbiter, inputProvider);
    }
}
