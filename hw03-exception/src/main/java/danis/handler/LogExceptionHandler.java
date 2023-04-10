package danis.handler;

import danis.command.Command;
import danis.command.CommandQueue;
import danis.command.LogCommand;

public class LogExceptionHandler implements ExceptionHandler {
    private final CommandQueue commandQueue;

    public LogExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Exception exception, Command command) {
        commandQueue.addLast(new LogCommand(exception, command));
    }
}
