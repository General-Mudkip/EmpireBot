package net.ryanland.empire.sys.gameplay.currency;

import net.ryanland.empire.bot.command.executor.exceptions.CannotAffordException;
import net.ryanland.empire.bot.command.executor.exceptions.CommandException;
import net.ryanland.empire.sys.file.database.documents.impl.Profile;
import net.ryanland.empire.util.NumberUtil;
import org.jetbrains.annotations.NotNull;

public record Price<T extends Number>(Currency currency, T amount) {

    public String format() {
        return format(false);
    }

    public String format(boolean underlined) {
        return String.format("%s %3$s%s%3$s", currency.getEmoji(), formatAmount(), underlined ? "__" : "");
    }

    public @NotNull String formatAmount() {
        return NumberUtil.format(amount);
    }

    @SuppressWarnings("unchecked")
    public void give(Profile profile) throws CommandException {
        if (!profile.roomFor((Price<Integer>) this)) {
            throw new CommandException("You do not have enough capacity.");
        }
        // TODO collect part of it.

        currency.update(profile, currency.get(profile).amount() + amount.intValue());
    }

    @SuppressWarnings("unchecked")
    public void buy(Profile profile) throws CommandException {
        if (!profile.canAfford((Price<Integer>) this)) {
            throw new CannotAffordException("You cannot afford this."); //TODO add "u need x more homie"
        }

        currency.update(profile, currency.get(profile).amount() - amount.intValue());
    }

}
