package danis.handler;

import danis.command.Command;
import danis.command.TwiceRepeatCommand;

public class RepeatTwiceThanLogExceptionHandlerStrategy implements ExceptionHandlerStrategy {
    @Override
    public String getExceptionHandler(Exception exception, Command command) {
        if (command instanceof TwiceRepeatCommand) {
            return LogExceptionHandler.class.getName();
        } else {
            return RepeatExceptionHandler.class.getName();
        }
    }
}
