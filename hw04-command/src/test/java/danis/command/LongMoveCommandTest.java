package danis.command;

import danis.exception.CommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@DisplayName("Класс длительного движения по прямой LongMoveCommand должен")
public class LongMoveCommandTest {
    private MoveCommand moveCommand;
    private CommandQueue commandQueue;
    private LongMoveCommand longMoveCommand;

    @BeforeEach
    void setUp() {
        moveCommand = mock(MoveCommand.class);
        commandQueue = mock(CommandQueue.class);
        longMoveCommand = new LongMoveCommand(moveCommand, commandQueue);
    }

    @DisplayName("Выполнять команду по движению, а затем ставить в очередь команду-повторитель всей команды LongMoveCommand")
    @Test
    public void shouldExecuteCheckFuelMoveBurnFuelCommands() {
        longMoveCommand.execute();

        verify(moveCommand, times(1)).execute();
        verify(commandQueue, times(1)).addLast(argThat(c -> c == longMoveCommand));

        InOrder inOrder = inOrder(moveCommand, commandQueue);
        inOrder.verify(moveCommand).execute();
        inOrder.verify(commandQueue).addLast(any(Command.class));
    }

    @DisplayName("Прекращать выполнение при выбросе исключения при движении")
    @Test
    public void shouldStopInCaseOfException() {
        RuntimeException exception = new RuntimeException("test");
        doThrow(exception).when(moveCommand).execute();
        assertThatThrownBy(() -> {
            longMoveCommand.execute();
        }).isInstanceOf(CommandException.class).hasMessageContaining(exception.getMessage()).hasCause(exception);

        verify(moveCommand, times(1)).execute();
        verify(commandQueue, times(0)).addLast(any(Command.class));
    }
}
