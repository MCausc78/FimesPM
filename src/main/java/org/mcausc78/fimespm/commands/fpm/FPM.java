package org.mcausc78.fimespm.commands.fpm;

import org.bukkit.command.CommandSender;
import org.mcausc78.fimespm.utils.ArrayUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public class FPM implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        String sub = ArrayUtils.getElement(args, 0, "");
        boolean b;
        switch(sub) {
            case "help":
                b = new HelpCommand().execute(cs, ArrayUtils.getElement(args, 1, ""));
                break;
            default:
                b = true;
        }
        return i;
    }
}