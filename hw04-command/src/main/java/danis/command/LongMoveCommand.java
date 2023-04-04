package danis.command;

import java.util.ArrayList;

public class LongMoveCommand extends MacroCommand{
    public LongMoveCommand(MoveCommand moveCommand, CommandQueue commandQueue) {
        super(new ArrayList<>());
        commands.add(moveCommand);
        commands.add(new QueueAddCommand(this, commandQueue));
    }
}
