package com.danis.command;

import com.danis.handler.queue.QueueHandler;
import com.danis.ioc.IoC;

public class QueueProcessCommand implements Command {
    @Override
    public void execute() {
        ((QueueHandler) IoC.resolve("Queue.Handler")).handle();
    }
}
