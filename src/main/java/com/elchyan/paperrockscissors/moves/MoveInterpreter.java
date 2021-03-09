package com.elchyan.paperrockscissors.moves;

public interface MoveInterpreter<T> {
    Move interpret(T obj);
}
