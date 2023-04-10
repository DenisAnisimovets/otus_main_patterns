package danis.app;

import danis.command.Command;
import danis.command.CommandQueue;
import danis.handler.ExceptionHandler;
import danis.handler.ExceptionHandlerStrategy;
import danis.handler.RouterExceptionHandler;

public class SpaceBattleApp {
    private final CommandQueue commandQueue;
    private final ExceptionHandler exceptionHandler;

    public SpaceBattleApp(CommandQueue commandQueue, ExceptionHandlerStrategy exceptionHandlerStrategy) {
        this.commandQueue = commandQueue;
        this.exceptionHandler = new RouterExceptionHandler(commandQueue, exceptionHandlerStrategy);
    }

    public void process() {
        Command command;
        while ((command = commandQueue.readFirst()) != null) {
            try {
                command.execute();
            } catch (Exception exception) {
                exceptionHandler.handle(exception, command);
            }
        }
    }
}
