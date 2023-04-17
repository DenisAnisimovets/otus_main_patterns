package com.danis.command;

import com.danis.ioc.IoC;

import java.util.function.Function;

public class SoftStopCommand implements Command{
    @Override
    public void execute() {
        ((Command) IoC.resolve("IoC.Register","CommandQueue.NextCommand", (Function<Object[], Object>) args1 ->
                ((CommandQueue) IoC.resolve("CommandQueue")).readFirst())).execute();
    }
}
