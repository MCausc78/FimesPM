package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;


public class LoadCommand {
    public static boolean execute(CommandSender cs, String plugin) {
        if(plugin.isEmpty()) {
            FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.ENABLE_USAGE_COMMAND)).forEach(message -> {
                cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
            });
            return true;
        }
        FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.LOAD_SUCCESS_COMMAND)).forEach(message -> {
            cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
        });
        return true;
    }
}
