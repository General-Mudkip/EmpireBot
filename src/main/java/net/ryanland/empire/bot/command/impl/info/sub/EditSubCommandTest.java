package net.ryanland.empire.bot.command.impl.info.sub;

import net.ryanland.empire.bot.command.arguments.ArgumentSet;
import net.ryanland.empire.bot.command.arguments.types.impl.StringArgument;
import net.ryanland.empire.bot.command.impl.SubCommand;
import net.ryanland.empire.bot.command.permissions.Permission;
import net.ryanland.empire.bot.events.CommandEvent;

public class EditSubCommandTest extends SubCommand {

    @Override
    public String getName() {
        return "edit";
    }

    @Override
    public Permission getPermission() {
        return Permission.USER;
    }

    @Override
    public ArgumentSet getArguments() {
        return new ArgumentSet().addArguments(
            new StringArgument()
                .name("test")
                .id("tid")
        );
    }

    @Override
    public void run(CommandEvent event) {
        String arg = event.getArgument("tid");
        event.reply(arg);
    }
}
