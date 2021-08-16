package net.ryanland.empire.bot.command.arguments.types.impl;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.ryanland.empire.bot.command.arguments.parsing.exceptions.ArgumentException;
import net.ryanland.empire.bot.command.arguments.types.SingleArgument;
import net.ryanland.empire.bot.events.CommandEvent;

public class MemberArgument extends SingleArgument<Member> {

    @Override
    public Member parsed(OptionMapping argument, CommandEvent event) throws ArgumentException {
        return argument.getAsMember();
    }
}
