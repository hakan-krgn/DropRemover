package com.hakan.drops.utils;

import com.hakan.drops.DropRemover;
import com.hakan.particle.ParticleAPI;

public class Variables {

    public static ParticleAPI particleAPI;

    public static boolean isActive;
    public static int removeTime;
    public static boolean effectActive;
    public static String effect;
    public static String hologram;

    public void setup() {
        isActive = DropRemover.config.getBoolean("settings.active");
        removeTime = DropRemover.config.getInt("settings.remove-time");
        effectActive = DropRemover.config.getBoolean("settings.effect-active");
        effect = DropRemover.config.getString("settings.effect");
        hologram = DropRemover.config.getString("settings.hologram");
    }
}