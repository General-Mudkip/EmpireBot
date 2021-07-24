package net.ryanland.empire.bot.command.arguments.types.impl;

import net.ryanland.empire.bot.command.CommandHandler;
import net.ryanland.empire.bot.command.arguments.parsing.exceptions.ArgumentException;
import net.ryanland.empire.bot.command.arguments.parsing.exceptions.MalformedArgumentException;
import net.ryanland.empire.bot.command.arguments.types.SingleArgument;
import net.ryanland.empire.bot.command.impl.Command;
import net.ryanland.empire.bot.events.CommandEvent;

public class CommandArgument extends SingleArgument<Command> {

    @Override
    public Command parsed(String argument, CommandEvent event) throws ArgumentException {
        Command command = CommandHandler.getCommand(argument);

        if (command == null) {
            throw new MalformedArgumentException(
                    "This command was not found."
            );
        } else {
            return command;
        }
    }
}
