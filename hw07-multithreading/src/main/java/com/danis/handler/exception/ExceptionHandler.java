package com.danis.handler.exception;

import com.danis.command.Command;

public interface ExceptionHandler {
    void handle(Exception exception, Command command);
}
