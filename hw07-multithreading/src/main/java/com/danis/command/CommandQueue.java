package com.danis.command;

public interface CommandQueue {
    void addLast(Command command);

    Command readFirst();

    int size();
}
