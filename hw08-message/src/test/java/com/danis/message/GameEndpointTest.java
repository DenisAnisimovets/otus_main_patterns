package com.danis.message;

import com.danis.command.Command;
import com.danis.command.CommandQueue;
import com.danis.command.InterpretCommand;
import com.danis.ioc.IoC;
import com.danis.ioc.ScopeBasedStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@DisplayName("Эндпойнт игры должен")
class GameEndpointTest {

    private CommandQueue queue;
    private String gameId;
    private GameEndpoint gameEndpoint;

    @BeforeEach
    void setUp() {
        // инициализация IoC
        ScopeBasedStrategy scopeBasedStrategy = new ScopeBasedStrategy();
        (scopeBasedStrategy.new InitScopeBasedIoCCommand()).execute();

        // подменяем зависимость очереди
        queue = mock(CommandQueue.class);
        ((Command) IoC.resolve("IoC.Register", "Games.CreateQueue", (Function<Object[], Object>) args1 -> {
            if (gameId.equals(args1[0])) {
                return queue;
            } else {
                return null;
            }
        })).execute();

        gameId = "game1";
        gameEndpoint = new GameEndpoint();
    }

    @DisplayName("Находить нужную игру и ставить в её очередь команду InterpretCommand")
    @Test
    public void shouldProcessWithCorrectMessage() {
        // создаём несколько игр
        IoC.resolve("Games.Create", gameId);
        IoC.resolve("Games.Create", "game2");
        IoC.resolve("Games.Create", "game3");

        // вызываем метод обработки эндпойнта
        String objectId = "123";
        String operationId = "Move";
        Object[] args = new Object[]{ "123", 1 };
        gameEndpoint.receive(new Message.Builder()
                .setGameId(gameId)
                .setObjectId(objectId)
                .setOperationId(operationId)
                .setArgs(args)
                .build()
        );

        verify(queue, times(1)).addLast(argThat(command -> {
            assertThat(command)
                    .isInstanceOf(InterpretCommand.class);
            return true;
        }));
    }

}

