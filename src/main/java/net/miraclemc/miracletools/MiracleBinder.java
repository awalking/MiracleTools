package net.miraclemc.miracletools;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import net.miraclemc.miracletools.config.config.Config;
import net.miraclemc.miracletools.utils.AchievementSpam;

import java.nio.file.Path;

public class MiracleBinder extends AbstractModule {
    private final MiracleTools plugin;

    public MiracleBinder(MiracleTools plugin) {
        this.plugin = plugin;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(MiracleTools.class).toInstance(this.plugin);

        bind(Path.class).annotatedWith(Names.named("pluginPath")).toInstance(plugin.getDataFolder().toPath());

        AchievementSpam spam = new AchievementSpam(plugin);
        bind(AchievementSpam.class).toInstance(spam);

        Config config = new Config();
        bind(Config.class).toInstance(config);
    }
}
