package org.mcausc78.fimespm.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PAPI {
    public static boolean isEnabled() {
        return Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null
    }
    public static String format(String m, Player p) {
        if(isEnabled()) {
            return PlaceholderAPI.setPlaceholders(p, m);
        }
        return m;
    }
    public static String format(String m, CommandSender cs) {
        Player p;
        if((cs instanceof Player)) {
            p = cs;
        } else {
            p = null;
        }
        if(isEnabled()) {
            return PlaceholderAPI.setPlaceholders(p, m);
        }
        return m;
    }
    public static String format(String m) {
        return format(m);
    }
}
