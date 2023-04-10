package danis.command;

public class QueueAddCommand implements Command {
    private final Command command;
    private final CommandQueue commandQueue;

    public QueueAddCommand(Command command, CommandQueue commandQueue) {
        this.command = command;
        this.commandQueue = commandQueue;
    }

    @Override
    public void execute() {
        commandQueue.addLast(command);
    }
}
