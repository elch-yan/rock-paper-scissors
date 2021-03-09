package com.elchyan.paperrockscissors.games;

import com.elchyan.paperrockscissors.arbiters.GameArbiter;
import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.moves.inputproviders.MoveInputProvider;
import com.elchyan.paperrockscissors.players.ArtificialPlayer;
import com.elchyan.paperrockscissors.players.Player;
import com.elchyan.paperrockscissors.players.RealPlayer;

import java.util.HashMap;
import java.util.Scanner;

public class CmdSinglePlayerGame implements Game {
    private final Scanner sc;
    private Player player;
    private final Player computer;
    private final MoveInputProvider inputProvider;

    private final GameArbiter arbiter;

    public CmdSinglePlayerGame(Scanner sc, GameArbiter arbiter, MoveInputProvider inputProvider) {
        this.sc = sc;
        this.arbiter = arbiter;
        computer = new ArtificialPlayer("Computer");
        this.inputProvider = inputProvider;
    }

    @Override
    public void play() {
        createRealPlayer();
        boolean isPlaying = true;
        while (isPlaying) {
            playRound();
            isPlaying = shouldBeContinued();
        }

        System.out.println("Thank you for playing!");
    }

    private boolean shouldBeContinued() {
        String answer = "";
        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.println("Do you want to continue? (Y/N)");
            answer = sc.nextLine().toLowerCase();
        }

        return answer.equals("y");
    }

    private void createRealPlayer() {
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        player = new RealPlayer(name, inputProvider);
    }

    private void playRound() {
        try {
            Move playerMove = player.getMove();
            Move computerMove = computer.getMove();

            System.out.printf("Computer move was: %s \n", computerMove.toString().toLowerCase());

            arbiter.judge(new HashMap<>(){{
                put(player, playerMove);
                put(computer, computerMove);
            }});

            printScores();
        } catch (IllegalArgumentException ex) {
            System.out.println("You've typed in illegal move, use one of 'rock' 'paper' 'scissors'");
        }
    }

    private void printScores() {
        System.out.printf("Your score: %d computer score: %d \n", player.getScore(), computer.getScore());
    }
}
