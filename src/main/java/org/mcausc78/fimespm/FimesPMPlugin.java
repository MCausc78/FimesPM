package org.mcausc78.fimespm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class FimesPMPlugin extends JavaPlugin {
    private static FimesPMPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public static FimesPMPlugin getInstance() {
        return this.instance;
    }

    public static Logger getPluginLogger() {
        return this.getLogger();
    }
    public static FileConfiguration getConfiguration() {
        return this.getConfig();
    }
}
