package net.ryanland.empire.sys.message.acceptors;

import net.dv8tion.jda.api.entities.Message;

public abstract class MessageAcceptor {

    public abstract boolean check(Message message);
}
