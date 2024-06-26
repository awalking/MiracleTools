package net.miraclemc.miracletools.commands;

import com.google.inject.Inject;
import net.miraclemc.miracletools.config.messages.MessagesConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.HashSet;
import java.util.Set;

public class CheckInCommand implements CommandExecutor{
    public static Set<String> toggle = new HashSet<String>();
    private final MessagesConfig messages;

    @Inject
    public CheckInCommand(MessagesConfig messages) {
        this.messages = messages;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(messages.messages.senderIsConsole);

            return true;
        }

        String nickname = player.getName();
        if (toggle.contains(nickname)) {
            Bukkit.broadcastMessage(messages.messages.startCheckIn);
            toggle.remove(nickname);
        } else {
            Bukkit.broadcastMessage(messages.messages.stopCheckIn);
            toggle.add(nickname);
        }
        return false;
    }
}
