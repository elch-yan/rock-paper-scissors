package com.elchyan.paperrockscissors.players;

import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.moves.inputproviders.MoveInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RealPlayerTest {
    @Test
    public void shouldGetMoveFromInputProvider() {
        MoveInputProvider mockProvider = mock(MoveInputProvider.class);
        Player player = new RealPlayer("test", mockProvider);

        when(mockProvider.requestMove(player)).thenReturn(Move.PAPER);

        assertEquals(Move.PAPER, player.getMove());
        verify(mockProvider, times(1)).requestMove(player);
    }
}