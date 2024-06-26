package net.miraclemc.miracletools.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import net.miraclemc.miracletools.config.config.Config;
import net.miraclemc.miracletools.config.messages.MessagesConfig;
import java.nio.file.Path;

@Singleton
public class ConfigManager {
    private final Config config;
    private final MessagesConfig messages;
    private final Path pluginPath;

    @Inject
    public ConfigManager(@Named("pluginPath") Path pluginPath, Config config, MessagesConfig messages) {
        this.config = config;
        this.messages = messages;
        this.pluginPath = pluginPath;
    }

    public void reloadConfigs() {
        config.reload(pluginPath.resolve("config.yml"));
        messages.reload(pluginPath.resolve("messages.yml"));
    }
}
