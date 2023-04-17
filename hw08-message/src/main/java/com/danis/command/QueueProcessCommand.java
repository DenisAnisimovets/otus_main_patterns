package com.danis.command;

import com.danis.handler.queue.QueueHandler;
import com.danis.ioc.IoC;

public class QueueProcessCommand implements Command {
    private final CommandQueue queue;

    public QueueProcessCommand(CommandQueue queue) {
        this.queue = queue;
    }

    @Override
    public void execute() {
        ((QueueHandler) IoC.resolve("Queue.Handler")).handle();
    }
}
