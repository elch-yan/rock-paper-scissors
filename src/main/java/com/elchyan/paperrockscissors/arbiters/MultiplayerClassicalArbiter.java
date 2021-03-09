package com.elchyan.paperrockscissors.arbiters;

import com.elchyan.paperrockscissors.games.GameOutcome;
import com.elchyan.paperrockscissors.moves.Move;
import com.elchyan.paperrockscissors.players.Player;

import java.util.*;

public class MultiplayerClassicalArbiter implements GameArbiter {
    private GameOutcomeResolver outcomeResolver;

    public MultiplayerClassicalArbiter(GameOutcomeResolver resolver) {
        this.outcomeResolver = resolver;
    }

    @Override
    public Map<Player, GameOutcome> judge(Map<Player, Move> pm) {
        if (pm == null || pm.values().size() < 2)
            throw new IllegalArgumentException();

        Map<Player, GameOutcome> results;

        Set<Move> moveSet = new HashSet<>(pm.values());
        if (checkDraw(moveSet))
            results = buildDrawResult(pm.keySet());
        else {
            Move winningMove = getWinningMove(moveSet);
            results = buildWinLossResult(pm, winningMove);
        }

        processResults(results);

        return results;
    }

    private boolean checkDraw(Set<Move> moveSet) {
        int size = moveSet.size();
        return size == 1 || size == 3;
    }

    private Move getWinningMove(Set<Move> moveSet) {
        List<Move> moves = new ArrayList<>(moveSet);
        GameOutcome result = outcomeResolver.getResultForPlayerMove(moves.get(0), moves.get(1));

        if (result == GameOutcome.WIN)
            return moves.get(0);

        return moves.get(1);
    }

    private Map<Player, GameOutcome> buildDrawResult(Set<Player> players) {
        Map<Player, GameOutcome> result = new HashMap<>();
        players.forEach(p -> result.put(p, GameOutcome.DRAW));

        return result;
    }

    private Map<Player, GameOutcome> buildWinLossResult(Map<Player, Move> pm, Move winningMove) {
        Map<Player, GameOutcome> result = new HashMap<>();

        pm.forEach((p, m) -> {
            if (m == winningMove)
                result.put(p, GameOutcome.WIN);
            else
                result.put(p, GameOutcome.LOSS);
        });

        return result;
    }

    private void processResults(Map<Player, GameOutcome> results) {
        results.forEach(Player::resultHandler);
    }
}
