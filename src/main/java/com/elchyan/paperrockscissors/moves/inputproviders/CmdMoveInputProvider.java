package com.elchyan.paperrockscissors.moves.inputproviders;

import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.moves.MoveInterpreter;
import com.elchyan.paperrockscissors.players.Player;

import java.util.Scanner;

public class CmdMoveInputProvider implements MoveInputProvider {
    private final Scanner sc;

    private final MoveInterpreter<String> interpreter;

    public CmdMoveInputProvider(Scanner sc, MoveInterpreter<String> interpreter) {
        this.sc = sc;
        this.interpreter = interpreter;
    }

    @Override
    public Move requestMove(Player player) {
        System.out.printf("%s please write down your move: ", player.getName());
        String strMove = sc.nextLine();

        return interpreter.interpret(strMove);
    }
}
