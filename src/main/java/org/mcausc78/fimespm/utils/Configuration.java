package org.mcausc78.fimespm.utils;

import org.bukkit.ChatColor;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    public static FileConfiguration getCfg() {
        return FimesPMPlugin.getInstance().getConfig();
    }
    public static String getKey(String s, String d) {
        return ChatColor.translateAlternateColorCodes('&', getCfg().getString(s, d));
    }
}
