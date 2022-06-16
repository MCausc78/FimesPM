package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;

public class RestartCommand {
    public static boolean execute(CommandSender cs, String plugin, String label) {
        if(plugin.isEmpty()) {
            FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.RESTART_USAGE_COMMAND).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs).replace("$label$", label)));
            return true;
        } else if(Bukkit.getServer().getPluginManager().getPlugin(plugin) == null) {
            FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.ERROR_PLUGIN_MISSING).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
            return true;
        }
        Plugin p = Bukkit.getPluginManager().getPlugin(plugin);
        Bukkit.getPluginManager().disablePlugin(p);
        Bukkit.getPluginManager().enablePlugin(p);
        FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.RESTART_SUCCESS_COMMAND).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs).replace("$plugin.name$", p.getName())));
        return true;
    }
}
