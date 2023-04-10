package danis.handler;

import danis.command.CommandQueue;
import danis.command.LogCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("Обработчик LogExceptionHandler должен")
class LogExceptionHandlerTest {
    private CommandQueue commandQueue;
    private LogExceptionHandler logExceptionHandler;

    @BeforeEach
    void setUp() {
        commandQueue = mock(CommandQueue.class);
        logExceptionHandler = new LogExceptionHandler(commandQueue);
    }

    @DisplayName("Ставить команду LogCommand в очередь")
    @Test
    public void shouldAddLogCommandToQueue() {
        logExceptionHandler.handle(new Exception("Test"), () -> { });
        verify(commandQueue).addLast(any(LogCommand.class));
    }
}