package danis.handler;

import danis.command.Command;
import danis.command.CommandQueue;
import danis.command.RepeatCommand;
import danis.command.TwiceRepeatCommand;

public class RepeatExceptionHandler implements ExceptionHandler {
    private final CommandQueue commandQueue;

    public RepeatExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Exception exception, Command command) {
        if (command instanceof RepeatCommand) {
            commandQueue.addLast(new TwiceRepeatCommand(command));
        } else {
            commandQueue.addLast(new RepeatCommand(command));
        }
    }
}
