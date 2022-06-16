package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;

public class HelpCommand {
    public static boolean execute(CommandSender cs) {
        FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.HELP_LIST)).forEach(message -> {
            cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
        });
        return true;
    }
}
