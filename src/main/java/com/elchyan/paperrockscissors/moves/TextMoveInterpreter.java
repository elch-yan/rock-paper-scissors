package com.elchyan.paperrockscissors.moves;

public class TextMoveInterpreter implements MoveInterpreter<String> {
    @Override
    public Move interpret(String text) {
        switch(text.toLowerCase().trim()) {
            case "rock": return Move.ROCK;
            case "paper": return Move.PAPER;
            case "scissors": return Move.SCISSORS;
            default:
                throw new IllegalArgumentException("Could not interpret move: " + text);
        }
    }
}
