package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;

public class EnableCommand {
    public static boolean execute(CommandSender cs, String plugin) {
        if(plugin.isEmpty()) {
            FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.ENABLE_USAGE_COMMAND)).forEach(message -> {
                cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
            });
            return true;
        } else if(Bukkit.getServer().getPluginManager().getPlugin(plugin) == null) {
            FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.ERROR_PLUGIN_MISSING)).forEach(message -> {
                cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
            });
            return true;
        } else if(Bukkit.getServer().getPluginManager().getPlugin(plugin).isEnabled()) {
            FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.ENABLE_ERROR_PLUGIN_ENABLED_COMMAND)).forEach(message -> {
                cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
            });
            return true;
        }
        Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(plugin));
        FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.ENABLE_SUCCESS_COMMAND)).forEach(message -> {
            cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
        });
        return true;
    }
}
