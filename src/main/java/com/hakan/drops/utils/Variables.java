package com.hakan.drops.utils;

import com.hakan.drops.DropRemover;
import com.hakan.particle.ParticleAPI;
import org.bukkit.configuration.file.FileConfiguration;

public class Variables {

    public static ParticleAPI particleAPI;

    public static boolean isActive;
    public static int removeTime;
    public static boolean effectActive;
    public static String effect;
    public static String hologram;

    public void setup() {
        FileConfiguration config = DropRemover.config.getFileConfiguration();

        isActive = config.getBoolean("settings.active");
        removeTime = config.getInt("settings.remove-time");
        effectActive = config.getBoolean("settings.effect-active");
        effect = config.getString("settings.effect");
        hologram = config.getString("settings.hologram");
    }
}