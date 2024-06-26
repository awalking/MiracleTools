package net.miraclemc.miracletools;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.miraclemc.miracletools.config.ConfigManager;
import net.miraclemc.miracletools.config.messages.MessagesConfig;
import net.miraclemc.miracletools.utils.AchievementSpam;
import net.miraclemc.miracletools.commands.CheckInCommand;
import net.miraclemc.miracletools.commands.CheckInListCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MiracleTools extends JavaPlugin {
    @Override
    public void onEnable() {
        MiracleBinder module = new MiracleBinder(this);
        Injector injector = module.createInjector();

        this.getCommand("checkin").setExecutor(new CheckInCommand(injector.getInstance(MessagesConfig.class)));
        this.getCommand("checkin-list").setExecutor(new CheckInListCommand(injector.getInstance(MessagesConfig.class)));
        injector.getInstance(AchievementSpam.class).startAchievementTask();

        ConfigManager configManager = injector.getInstance(ConfigManager.class);
        configManager.reloadConfigs();

        getLogger().info("MiracleTools has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MiracleTools has been disabled!");
    }
}