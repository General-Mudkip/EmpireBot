package net.ryanland.empire.sys.database.documents.serializer.global;

import net.ryanland.empire.bot.command.executor.CommandHandler;
import net.ryanland.empire.bot.command.impl.Command;
import net.ryanland.empire.sys.database.documents.serializer.Serializer;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class DisabledCommandsSerializer implements Serializer<List<String>, List<Command>> {

    private static final DisabledCommandsSerializer instance = new DisabledCommandsSerializer();

    public static DisabledCommandsSerializer getInstance() {
        return instance;
    }

    @Override
    public List<String> serialize(List<Command> toSerialize) {
        return toSerialize.stream()
                .map(Command::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Command> deserialize(List<String> toDeserialize) {
        return toDeserialize.stream()
                .map(CommandHandler::getCommand)
                .collect(Collectors.toList());
    }
}
