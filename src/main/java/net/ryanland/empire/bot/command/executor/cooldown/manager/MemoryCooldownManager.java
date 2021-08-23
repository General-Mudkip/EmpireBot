package net.ryanland.empire.bot.command.executor.cooldown.manager;

import net.dv8tion.jda.api.entities.User;
import net.ryanland.empire.bot.command.executor.cooldown.Cooldown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Memory implementation of {@link CooldownManager}. Stores cooldowns in a private {@link HashMap}.
 * <strong>WARNING:</strong> This means these cooldowns will reset on restart!
 */
public class MemoryCooldownManager implements CooldownManager {

    private static final HashMap<User, List<Cooldown>> COOLDOWNS = new HashMap<>();
    private static final MemoryCooldownManager INSTANCE = new MemoryCooldownManager();

    public static MemoryCooldownManager getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Cooldown> get(User user) {
        return COOLDOWNS.getOrDefault(user, new ArrayList<>());
    }

    @Override
    public List<Cooldown> put(User user, List<Cooldown> cooldowns) {
        return COOLDOWNS.put(user, cooldowns);
    }

    @Override
    public Cooldown put(User user, Cooldown cooldown) {
        List<Cooldown> cooldowns = get(user);
        cooldowns.add(cooldown);

        put(user, cooldowns);
        return cooldown;
    }

    @Override
    public Cooldown remove(User user, Cooldown cooldown) {
        List<Cooldown> cooldowns = get(user);
        cooldowns.remove(cooldown);

        if (cooldowns.isEmpty()) {
            purge(user);
        } else {
            put(user, cooldown);
        }

        return cooldown;
    }

    @Override
    public void purge(User user) {
        COOLDOWNS.remove(user);
    }
}
