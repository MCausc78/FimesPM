package org.mcausc78.fimespm.commands.fpm;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.ConfigMessagesKeys;
import org.mcausc78.fimespm.FimesPMPlugin;
import org.mcausc78.fimespm.commands.fpm.sub.LoadCommand;
import org.mcausc78.fimespm.commands.fpm.sub.HelpCommand;
import org.mcausc78.fimespm.commands.fpm.sub.EnableCommand;
import org.mcausc78.fimespm.commands.fpm.sub.RestartCommand;
import org.mcausc78.fimespm.commands.fpm.sub.DisableCommand;
import org.mcausc78.fimespm.utils.ArrayUtils;
import org.mcausc78.fimespm.utils.PAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public class FPM implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        String sub = ArrayUtils.getElement(args, 0, "");
        boolean b;
        if(!(cs.hasPermission("fimespm.command.fpm"))) {
            FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
            return true;
        }
        switch(sub) {
            case "help":
                //b = new HelpCommand().execute(cs, ArrayUtils.getElement(args, 1, ""), label);
                if(!(cs.hasPermission("fimespm.command.fpm.help"))) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                    return true;
                }
                b = HelpCommand.execute(cs, label);

                break;
            case "disable":
                if(!(cs.hasPermission("fimespm.command.fpm.disable"))) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                    return true;
                }
                b = DisableCommand.execute(cs, ArrayUtils.getElement(args, 2, ""), label);
                break;
            case "enable":
                if(!(cs.hasPermission("fimespm.command.fpm.enable"))) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                    return true;
                }
                b = EnableCommand.execute(cs, ArrayUtils.getElement(args, 2, ""), label);
                break;
            case "load":
                if(!(cs.hasPermission("fimespm.command.fpm.load"))) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                    return true;
                }
                b = LoadCommand.execute(cs, ArrayUtils.getElement(args, 2, ""), label);
                break;
            case "restart":
                if(!(cs.hasPermission("fimespm.command.fpm.restart"))) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.NO_PERMISSION).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                    return true;
                }
                b = RestartCommand.execute(cs, ArrayUtils.getElement(args, 2, ""), label);
                break;
            default:
                if(sub.isEmpty()) {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.TRY_HELP).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                } else {
                    FimesPMPlugin.getInstance().getConfig().getStringList(ConfigMessagesKeys.UNKNOWN_SUBCOMMAND).forEach(message -> cs.sendMessage(PAPI.format(ChatColor.translateAlternateColorCodes('&', message), cs)));
                }
                b = true;
        }
        return b;
    }
}