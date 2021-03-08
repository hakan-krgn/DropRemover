package com.hakan.drops.cmd;

import com.hakan.drops.DropRemover;
import com.hakan.drops.utils.Variables;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equals("drops")) {
            if (args[0].equals("reload") || args[0].equals("yenile")) {
                DropRemover.config.reload();

                new Variables().setup();

                commandSender.sendMessage("§aDropRemover has been reloaded.");
            }
        }
        return false;
    }
}