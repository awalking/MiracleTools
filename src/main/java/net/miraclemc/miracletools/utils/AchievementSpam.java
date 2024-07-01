package net.miraclemc.miracletools.utils;

import eu.endercentral.crazy_advancements.JSONMessage;
import eu.endercentral.crazy_advancements.advancement.AdvancementDisplay;
import eu.endercentral.crazy_advancements.advancement.ToastNotification;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import com.google.inject.Inject;

public class AchievementSpam {

    private final Plugin plugin;

    @Inject
    public AchievementSpam(Plugin plugin) {
        this.plugin = plugin;
    }

    public void startAchievementTask() {
        ItemStack icon = new ItemStack(Material.DIAMOND);
        JSONMessage description = new JSONMessage(new TextComponent("&aНовые возможности с\nподпиской &eMiracle+"));
        AdvancementDisplay.AdvancementFrame frame = AdvancementDisplay.AdvancementFrame.GOAL;

        ToastNotification notification = new ToastNotification(icon, description, frame);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("&aНадоели всплывашки? Купи ебливый донат сын свиньи");
                    notification.send(player);
                }
            }
        }.runTaskTimer(plugin, 200, 600);
    }
}
