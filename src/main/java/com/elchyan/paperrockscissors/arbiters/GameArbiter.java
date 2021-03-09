package com.elchyan.paperrockscissors.arbiters;


import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.players.Player;

import java.util.Map;

public interface GameArbiter {
    Map<Player, GameOutcome> judge(Map<Player, Move> pm);
}
