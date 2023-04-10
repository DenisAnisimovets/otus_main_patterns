package danis.handler;

import danis.command.Command;
import danis.command.RepeatCommand;

public class RepeatThanLogExceptionHandlerStrategy implements ExceptionHandlerStrategy {

    @Override
    public String getExceptionHandler(Exception exception, Command command) {
        if(command instanceof RepeatCommand) {
            return LogExceptionHandler.class.getName();
        } else {
            return RepeatExceptionHandler.class.getName();
        }
    }

}
