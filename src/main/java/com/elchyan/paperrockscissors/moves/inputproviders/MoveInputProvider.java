package com.elchyan.paperrockscissors.moves.inputproviders;

import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.players.Player;

public interface MoveInputProvider {
    Move requestMove(Player player);
}
