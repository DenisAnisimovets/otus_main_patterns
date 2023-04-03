package danis.handler;

import danis.command.Command;

public interface ExceptionHandlerStrategy {
    String getExceptionHandler(Exception exception, Command command);
}
