package org.mcausc78.fimespm;

import org.mcausc78.fimespm.commands.fpm.FPM;
import org.bukkit.plugin.java.JavaPlugin;

public class FimesPMPlugin extends JavaPlugin {
    private static FimesPMPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("fpm").setExecutor(new FPM());
    }

    @Override
    public void onDisable() {

    }

    public static FimesPMPlugin getInstance() {
        return instance;
    }
}
