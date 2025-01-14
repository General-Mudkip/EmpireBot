package net.ryanland.empire.sys.message.interactions.menu.confirm;

import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.Button;
import net.ryanland.empire.bot.events.CommandEvent;
import net.ryanland.empire.sys.message.builders.PresetBuilder;
import net.ryanland.empire.sys.message.interactions.ButtonClickContainer;
import net.ryanland.empire.sys.message.interactions.ButtonHandler;
import net.ryanland.empire.sys.message.interactions.InteractionUtil;
import net.ryanland.empire.sys.message.interactions.menu.InteractionMenu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public record ConfirmMenu(String description, Runnable confirmAction,
                          String confirmedDescription)
        implements InteractionMenu {

    @Override
    public void send(CommandEvent commandEvent) {
        // Create buttons
        List<Button> buttons = Arrays.asList(
                Button.success("confirm", "Confirm")
                        .withEmoji(Emoji.fromUnicode("✅")),
                Button.danger("dismiss", "Cancel")
                        .withEmoji(Emoji.fromUnicode("❎"))
        );

        // Create embed
        PresetBuilder embed = new PresetBuilder()
                .setTitle("Confirm")
                .setDescription(description)
                .addLogo();

        // Send the message and set the action rows
        InteractionHook hook = commandEvent.performReply(embed.build())
                .addActionRows(InteractionUtil.of(buttons))
                .setEphemeral(true)
                .complete();

        // Add a listener for when a button is clicked
        ButtonHandler.addListener(hook,
                buttonEvent -> new ButtonHandler.ButtonListener(
                        commandEvent.getUser().getIdLong(),
                        clickEvent -> new ButtonClickContainer(
                                event -> {
                                    switch (event.getComponentId()) {
                                        case "confirm" -> {
                                            event.deferEdit().queue();
                                            event.getHook()
                                                    .editOriginalComponents(Collections.emptyList())
                                                    .setEmbeds(embed.setDescription(confirmedDescription).build())
                                                    .queue();
                                            confirmAction.run();
                                        }
                                        case "dismiss" -> {
                                            event.deferEdit().queue();
                                            event.getHook()
                                                    .editOriginalComponents(Collections.emptyList())
                                                    .setEmbeds(embed.setDescription("Action canceled.").build())
                                                    .queue();
                                        }
                                    }
                                }
                        )
                )
        );
    }
}
