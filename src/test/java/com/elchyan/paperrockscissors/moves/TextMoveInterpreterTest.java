package com.elchyan.paperrockscissors.moves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextMoveInterpreterTest {
    private TextMoveInterpreter interpreter = new TextMoveInterpreter();

    @Test
    public void shouldReturnRightMoveOnText() {
        assertEquals(Move.ROCK, interpreter.interpret("ROCK"));
        assertEquals(Move.PAPER, interpreter.interpret("PAPER"));
        assertEquals(Move.SCISSORS, interpreter.interpret("SCISSORS"));
    }

    @Test
    public void shouldBeCaseInsensitive() {
        assertEquals(Move.SCISSORS, interpreter.interpret("ScIsSors"));
    }

    @Test
    public void shouldIgnoreBeginningAndEndingWhitespaces() {
        assertEquals(Move.ROCK, interpreter.interpret(" rock "));
    }
}