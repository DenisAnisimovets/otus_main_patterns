package com.danis.handler.exception;

import com.danis.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogExceptionHandler implements ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExceptionHandler.class);

    @Override
    public void handle(Exception exception, Command command) {
        LOGGER.error("Exception type={} message={} was thrown while executing command={}",
                exception.getClass().getName(), exception.getMessage(), command.getClass().getName());
    }
}
