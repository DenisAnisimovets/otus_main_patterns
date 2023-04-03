package danis.handler;

import danis.command.Command;
import danis.command.CommandQueue;
import danis.exception.NoSuchExceptionHandlerException;

import java.util.HashMap;
import java.util.Map;

public class RouterExceptionHandler implements ExceptionHandler {
    private final ExceptionHandlerStrategy exceptionHandlerStrategy;
    private final Map<String, ExceptionHandler> exceptionHandlers;

    public RouterExceptionHandler(CommandQueue commandQueue, ExceptionHandlerStrategy exceptionHandlerStrategy) {
        this.exceptionHandlerStrategy = exceptionHandlerStrategy;
        this.exceptionHandlers = new HashMap<>();
        // в следующих ДЗ будет вынесено в IoC
        this.exceptionHandlers.put(LogExceptionHandler.class.getName(), new LogExceptionHandler(commandQueue));
        this.exceptionHandlers.put(RepeatExceptionHandler.class.getName(), new RepeatExceptionHandler(commandQueue));
    }

    @Override
    public void handle(Exception exception, Command command) {
        ExceptionHandler exceptionHandler = exceptionHandlers.get(exceptionHandlerStrategy.getExceptionHandler(exception, command));
        if (exceptionHandler == null) {
            throw new NoSuchExceptionHandlerException("No exception handler found");
        }
        exceptionHandler.handle(exception, command);
    }
}
