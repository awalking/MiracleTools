package net.miraclemc.miracletools.commands;

import com.google.inject.Inject;
import net.miraclemc.miracletools.config.messages.MessagesConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class CheckInListCommand implements CommandExecutor {
    Set<String> adminsList = CheckInCommand.toggle;
    private final MessagesConfig messages;

    @Inject
    public CheckInListCommand(MessagesConfig messages) {
        this.messages = messages;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String adminsOnline = String.join(", ", adminsList);
        if (adminsOnline.isEmpty()) {
            sender.sendMessage(messages.messages.noAdmins);
        } else {
            sender.sendMessage(messages.messages.adminsList);
        }

        return false;
    }
}
