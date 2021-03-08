package com.hakan.drops;

import com.hakan.drops.cmd.Commands;
import com.hakan.drops.listener.DropItemListener;
import com.hakan.drops.utils.Metrics;
import com.hakan.drops.utils.Variables;
import com.hakan.drops.utils.yaml.Yaml;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DropRemover extends JavaPlugin {

    public static Yaml config;

    private static DropRemover instance;

    public static DropRemover getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        config = new Yaml(getDataFolder() + "/config.yml", "config.yml");

        new Metrics(this, 10384);
        new Variables().setup();

        Bukkit.getPluginManager().registerEvents(new DropItemListener(), this);
        getCommand("drops").setExecutor(new Commands());
    }
}