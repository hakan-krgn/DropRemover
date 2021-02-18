package com.hakan.drops.cmd;

import com.hakan.drops.DropRemover;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equals("drops")) {
            if (args[0].equals("reload") || args[0].equals("yenile")) {
                DropRemover.config = YamlConfiguration.loadConfiguration(new File(DropRemover.getInstance().getDataFolder() + "/config.yml"));
                commandSender.sendMessage("§aDropRemover has been reloaded.");
            }
        }
        return false;
    }
}