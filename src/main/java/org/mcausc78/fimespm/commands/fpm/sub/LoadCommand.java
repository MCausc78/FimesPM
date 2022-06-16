package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;

import java.io.File;


public class LoadCommand {
    public static boolean execute(CommandSender cs, String filename, String label) {
        if(filename.isEmpty()) {
            FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.LOAD_USAGE_COMMAND).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs).replace("$label$", label)));
            return true;
        }
        String[] f = filename.split(String.valueOf(File.separatorChar));
        File file = new File(f[f.length-1].replace(".jar", "") + ".jar");
        if(!(file.exists())) {
            FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.LOAD_FILE_IS_MISSING_COMMAND).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
            return true;
        }
        String localepath = ConfigMessagesKeys.LOAD_SUCCESS_COMMAND;
        Plugin p;
        try {
            p = Bukkit.getServer().getPluginManager().loadPlugin(file);
        } catch (Exception ex) {
            for(StackTraceElement ste : ex.getStackTrace()) {
                String s = ste.toString();
                cs.sendMessage(s);
            }
            return true;
        }
        if(FimesPMPlugin.getInstance().getConfig().getBoolean("settings.autoenable-when-loaded", true)) {
            Bukkit.getServer().getPluginManager().enablePlugin(p);
            localepath = ConfigMessagesKeys.LOAD_SUCCESS_AND_ENABLED_COMMAND;
        }
        FimesPMPlugin.getInstance().getConfig().getStringList(localepath).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
        return true;
    }
}
