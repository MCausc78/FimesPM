package org.mcausc78.fimespm.commands.fpm.sub;

import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;

public class HelpCommand {
    public static int execute(CommandSender cs, String ) {
        FimesPMPlugin.getInstance().getConfig().getStringList(HELP_LIST_KEY).forEach(message -> {

        });
        return true;
    }
}
