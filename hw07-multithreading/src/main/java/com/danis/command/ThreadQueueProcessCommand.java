package com.danis.command;

public class ThreadQueueProcessCommand implements Command {
    @Override
    public void execute() {
        new Thread(() -> {
            new QueueProcessCommand().execute();
        }).start();
    }
}
