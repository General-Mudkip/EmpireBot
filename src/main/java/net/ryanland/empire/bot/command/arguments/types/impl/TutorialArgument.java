package net.ryanland.empire.bot.command.arguments.types.impl;

import net.ryanland.empire.bot.command.arguments.parsing.exceptions.ArgumentException;
import net.ryanland.empire.bot.command.arguments.parsing.exceptions.MalformedArgumentException;
import net.ryanland.empire.bot.command.arguments.types.SingleArgument;
import net.ryanland.empire.sys.tutorials.Tutorial;
import net.ryanland.empire.sys.tutorials.TutorialHandler;
import net.ryanland.empire.bot.events.CommandEvent;

public class TutorialArgument extends SingleArgument<Tutorial> {

    public Tutorial parsed(String id, String name, String description) throws ArgumentException {
        Tutorial tutorial = TutorialHandler.getTutorial(id);

        if (tutorial == null) {
            throw new MalformedArgumentException(
                    "This tutorial was not found."
            );
        } else {
            return tutorial;
        }
    }

    @Override
    public Tutorial parsed(String argument, CommandEvent event) throws ArgumentException {
        return null;
    }
}