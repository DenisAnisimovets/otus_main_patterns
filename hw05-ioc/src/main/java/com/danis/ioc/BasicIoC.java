package com.danis.ioc;

import com.danis.command.Command;

public class BasicIoC implements IoC {
    private final Strategy defaultStrategy = new DefaultStrategy();
    private Strategy strategy;

    BasicIoC() {
        this.strategy = defaultStrategy;
    }

    @Override
    public <T> T resolve(String key, Object... args) {
        return (T) strategy.resolve(key, args);
    }


    class DefaultStrategy implements Strategy {

        @Override
        public Object resolve(String key, Object... args) {
            if ("IoC.SetupStrategy".equals(key)) {
                return new SetupStrategyCommand((Strategy) args[0]);
            } else if ("IoC.Default".equals(key)) {
                return this;
            } else {
                throw new IllegalArgumentException(String.format("Unknown key %s", key));
            }
        }
    }


    class SetupStrategyCommand implements Command {

        private final Strategy newStrategy;

        public SetupStrategyCommand(Strategy newStrategy) {
            this.newStrategy = newStrategy;
        }

        @Override
        public void execute() {
            BasicIoC.this.strategy = newStrategy;
        }
    }
}
