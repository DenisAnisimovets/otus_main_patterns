package danis.handler;

import danis.command.Command;

public interface ExceptionHandler {
    void handle(Exception exception, Command command);
}
