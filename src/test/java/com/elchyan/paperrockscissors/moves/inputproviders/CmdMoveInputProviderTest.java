package com.elchyan.paperrockscissors.moves.inputproviders;

import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.moves.MoveInterpreter;
import com.elchyan.paperrockscissors.moves.TextMoveInterpreter;
import com.elchyan.paperrockscissors.players.RealPlayer;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CmdMoveInputProviderTest {
    @Test
    public void shouldGetMoveFromUserInput() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("rock");
        MoveInterpreter<String> interpreter = new TextMoveInterpreter();

        CmdMoveInputProvider provider = new CmdMoveInputProvider(mockScanner, interpreter);
        RealPlayer pl = new RealPlayer("testPlayer", provider);

        assertEquals(Move.ROCK, provider.requestMove(pl));
    }
}