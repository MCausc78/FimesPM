package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.utils.PAPI;

public class HelpCommand {
    public static boolean execute(CommandSender cs, String label) {
        FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.HELP_LIST).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs).replace("$label$", label)));
        return true;
    }
}
