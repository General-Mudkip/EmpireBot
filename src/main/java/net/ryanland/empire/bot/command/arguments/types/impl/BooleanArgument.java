package net.ryanland.empire.bot.command.arguments.types.impl;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.ryanland.empire.bot.command.arguments.parsing.exceptions.ArgumentException;
import net.ryanland.empire.bot.command.arguments.types.SingleArgument;
import net.ryanland.empire.bot.events.CommandEvent;

import javax.swing.text.html.Option;

public class BooleanArgument extends SingleArgument<Boolean> {

    @Override
    public OptionType getType() {
        return OptionType.BOOLEAN;
    }

    @Override
    public Boolean parsed(OptionMapping argument, CommandEvent event) throws ArgumentException {
        return argument.getAsBoolean();
    }
}
