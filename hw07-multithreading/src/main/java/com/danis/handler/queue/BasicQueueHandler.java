package com.danis.handler.queue;

import com.danis.command.Command;
import com.danis.handler.exception.ExceptionHandler;
import com.danis.ioc.IoC;

public class BasicQueueHandler implements QueueHandler {
    @Override
    public void handle() {
        Command command;
        while ((command = IoC.resolve("CommandQueue.NextCommand")) != null) {
            try {
                command.execute();
            } catch (Exception exception) {
                ((ExceptionHandler) IoC.resolve("Exception.Handler")).handle(exception, command);
            }
        }
    }
}
