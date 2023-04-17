package com.danis.message;

import com.danis.ioc.IoC;
import com.danis.command.GameCommand;

/**
 * Принимает входящее сообщение и конвертирует в InterpretCommand.
 * Определяет игру, которой адресовано сообщение (из рутового скоупа), создаёт InterpretCommand и ставит в очередь этой игры.
 */
public class GameEndpoint implements Endpoint {

    public void receive(Message message) {
        GameCommand game = IoC.resolve("Games.GetById", message.getGameId());
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        game.new AddToGameQueueCommand(IoC.resolve("InterpretCommand", message.getGameId(), message.getObjectId(), message.getOperationId(), message.getArgs())).execute();
    }
}
