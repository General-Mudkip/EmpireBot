package net.ryanland.empire.bot.command.impl;

import net.ryanland.empire.bot.command.help.Category;
import net.ryanland.empire.bot.command.help.CommandData;
import net.ryanland.empire.bot.command.arguments.ArgumentSet;
import net.ryanland.empire.bot.command.permissions.Permission;
import net.ryanland.empire.bot.events.CommandEvent;

public abstract class Command {

    public abstract CommandData getData();

    public String getName() {
        return getData().getName();
    }

    public String getUppercasedName() {
        return getName().substring(0, 1).toUpperCase() + getName().substring(1);
    }

    public String[] getAliases() {
        return getData().getAliases();
    }

    public String getDescription() {
        return getData().getDescription();
    }

    public Category getCategory() {
        return getData().getCategory();
    }

    public Permission getPermission() {
        return getData().getPermission();
    }

    public boolean requiresProfile() {
        return getData().requiresProfile();
    }

    public abstract ArgumentSet getArguments();

    public abstract void run(CommandEvent event);
}
