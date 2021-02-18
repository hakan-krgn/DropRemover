package com.hakan.drops.nms.nmsparticle;

import com.hakan.drops.nms.DropNMS;
import net.minecraft.server.v1_13_R1.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_13_R1.CraftParticle;
import org.bukkit.craftbukkit.v1_13_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SpawnParticle_v1_13_R1 implements DropNMS.Particle {

    @Override
    public void spawnParticle(String particle, Location loc, double offset1, double offset2, double offset3, double speed, int amount) {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(CraftParticle.toNMS(Particle.valueOf(particle)), true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) offset1, (float) offset2, (float) offset3, (float) speed, amount);
        for (Player p : loc.getWorld().getPlayers()) ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
}