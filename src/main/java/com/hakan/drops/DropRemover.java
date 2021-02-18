package com.hakan.drops;

import com.hakan.drops.cmd.Commands;
import com.hakan.drops.listener.DropItemListener;
import com.hakan.drops.nms.DropNMS;
import com.hakan.drops.utils.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class DropRemover extends JavaPlugin {

    public static FileConfiguration config;

    private static DropRemover instance;

    public static DropRemover getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        new Metrics(this, 10384);

        Bukkit.getPluginManager().registerEvents(new DropItemListener(), this);
        getCommand("drops").setExecutor(new Commands());

        new DropNMS().setup();

        File file = new File(getDataFolder() + "/config.yml");
        config = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            config.set("settings.active", true);
            config.set("settings.remove-time", 15);
            config.set("settings.effect-active", true);
            config.set("settings.effect", "FLAME");
            config.set("settings.hologram", "&c[&4%time%&c] &f%material% &8(x%amount%)");
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}