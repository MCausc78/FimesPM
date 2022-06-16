package org.mcausc78.fimespm.commands.fpm;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.commands.fpm.sub.HelpCommand;
import org.mcausc78.fimespm.commands.fpm.sub.EnableCommand;
import org.mcausc78.fimespm.commands.fpm.sub.DisableCommand;
import org.mcausc78.fimespm.utils.ArrayUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.mcausc78.fimespm.utils.PAPI;

public class FPM implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        String sub = ArrayUtils.getElement(args, 0, "");
        boolean b;
        switch(sub) {
            case "help":
                //b = new HelpCommand().execute(cs, ArrayUtils.getElement(args, 1, ""));
                b = new HelpCommand().execute(cs);
                break;
            case "disable":
                b = new DisableCommand().execute(cs, ArrayUtils.getElement(args, 2, ""));
                break;
            case "enable":
                b = new EnableCommand().execute(cs, ArrayUtils.getElement(args, 2, ""));
                break;
            default:
                if(sub.isEmpty()) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.TRY_HELP)).forEach(message -> {
                        cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
                    });
                } else {
                    FimesPMPlugin.getInstance().getConfig().getStringList(String.valueOf(ConfigMessagesKeys.UNKNOWN_SUBCOMMAND)).forEach(message -> {
                        cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs));
                    });
                }
                b = true;
        }
        return b;
    }
}