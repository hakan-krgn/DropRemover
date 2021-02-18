package com.hakan.drops.nms;

import com.hakan.drops.nms.nmsparticle.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class DropNMS {

    private static Particle particle;

    public static Particle getParticle() {
        return particle;
    }

    public void setup() {
        String serverVersion = Bukkit.getServer().getClass().getName().split("\\.")[3];
        switch (serverVersion) {
            case "v1_8_R3":
                particle = new SpawnParticle_v1_8_R3();
                break;
            case "v1_9_R1":
                particle = new SpawnParticle_v1_9_R1();
                break;
            case "v1_9_R2":
                particle = new SpawnParticle_v1_9_R2();
                break;
            case "v1_10_R1":
                particle = new SpawnParticle_v1_10_R1();
                break;
            case "v1_11_R1":
                particle = new SpawnParticle_v1_11_R1();
                break;
            case "v1_12_R1":
                particle = new SpawnParticle_v1_12_R1();
                break;
            case "v1_13_R1":
                particle = new SpawnParticle_v1_13_R1();
                break;
            case "v1_13_R2":
                particle = new SpawnParticle_v1_13_R2();
                break;
            case "v1_14_R1":
                particle = new SpawnParticle_v1_14_R1();
                break;
            case "v1_15_R1":
                particle = new SpawnParticle_v1_15_R1();
                break;
            case "v1_16_R1":
                particle = new SpawnParticle_v1_16_R1();
                break;
            case "v1_16_R2":
                particle = new SpawnParticle_v1_16_R2();
                break;
            case "v1_16_R3":
                particle = new SpawnParticle_v1_16_R3();
                break;
        }
    }

    public interface Particle {
        void spawnParticle(String particle, Location loc, double offset1, double offset2, double offset3, double speed, int amount);
    }
}