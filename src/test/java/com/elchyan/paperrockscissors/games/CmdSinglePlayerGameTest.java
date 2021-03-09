package com.elchyan.paperrockscissors.games;

import com.elchyan.paperrockscissors.arbiters.ClassicalGameOutcomeResolver;
import com.elchyan.paperrockscissors.arbiters.GameArbiter;
import com.elchyan.paperrockscissors.arbiters.GameOutcomeResolver;
import com.elchyan.paperrockscissors.arbiters.MultiplayerClassicalArbiter;
import com.elchyan.paperrockscissors.moves.MoveInterpreter;
import com.elchyan.paperrockscissors.moves.TextMoveInterpreter;
import com.elchyan.paperrockscissors.moves.inputproviders.CmdMoveInputProvider;
import com.elchyan.paperrockscissors.moves.inputproviders.MoveInputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class CmdSinglePlayerGameTest {
    private Scanner mockScanner;
    private CmdSinglePlayerGame game;
    private final GameOutcomeResolver outcomeResolver = new ClassicalGameOutcomeResolver();
    private final GameArbiter arbiter = new MultiplayerClassicalArbiter(outcomeResolver);
    private final MoveInterpreter<String> interpreter = new TextMoveInterpreter();

    @BeforeEach
    public void beforeEach() {
        mockScanner = mock(Scanner.class);

        MoveInputProvider inputProvider = new CmdMoveInputProvider(mockScanner, interpreter);
        game = new CmdSinglePlayerGame(mockScanner, arbiter, inputProvider);
    }

    @Test
    public void shouldBeAbleToStartAndPlayOneGame() {
        when(mockScanner.nextLine())
                .thenReturn("testPlayer") // player name
                .thenReturn("rock") // player move
                .thenReturn("n"); // end game

        game.play();
        verify(mockScanner, times(3)).nextLine();
    }

    @Test
    public void shouldBeAbleToStartAndPlayTwoGames() {
        when(mockScanner.nextLine())
                .thenReturn("testPlayer") // player name
                .thenReturn("rock") // player move
                .thenReturn("y") // continue
                .thenReturn("paper") // player move
                .thenReturn("n"); // end game

        game.play();
        verify(mockScanner, times(5)).nextLine();
    }

    @Test
    public void shouldBeAbleToContinuePlayingAfterWrongMoveInput() {
        when(mockScanner.nextLine())
                .thenReturn("testPlayer") // player name
                .thenReturn("roc") // player wrong input move
                .thenReturn("y") // continue
                .thenReturn("paper") // player move
                .thenReturn("n"); // end game

        game.play();
        verify(mockScanner, times(5)).nextLine();
    }

    @Test
    public void shouldAskIfWantToContinueAgainAfterWrongInput() {
        when(mockScanner.nextLine())
                .thenReturn("testPlayer") // player name
                .thenReturn("rock") // player move
                .thenReturn("p") // wrong input
                .thenReturn("no") // wrong input
                .thenReturn("yes") // wrong input
                .thenReturn("n"); // end game

        game.play();
        verify(mockScanner, times(6)).nextLine();
    }
}