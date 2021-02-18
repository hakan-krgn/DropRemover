package com.hakan.drops.listener;

import com.hakan.drops.DropRemover;
import com.hakan.drops.nms.DropNMS;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DropItemListener implements Listener {

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        boolean isActive = DropRemover.config.getBoolean("settings.active");
        if (isActive) {
            int deleteTime = DropRemover.config.getInt("settings.remove-time");
            String hologram = ChatColor.translateAlternateColorCodes('&', DropRemover.config.getString("settings.hologram").replace("%material%", event.getItemDrop().getItemStack().getType().name()));
            event.getItemDrop().setCustomNameVisible(true);
            event.getItemDrop().setCustomName(hologram.replace("%amount%", event.getItemDrop().getItemStack().getAmount() + "").replace("%time%", deleteTime + ""));
            final int[] counter = {0};
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (event.getItemDrop().isDead()) {
                        cancel();
                        return;
                    }
                    if (counter[0] >= deleteTime) {
                        event.getItemDrop().remove();
                        boolean isParticle = DropRemover.config.getBoolean("settings.effect-active");
                        if (isParticle) {
                            String particleName = DropRemover.config.getString("settings.effect");
                            DropNMS.getParticle().spawnParticle(particleName, event.getItemDrop().getLocation(), 0.1, 0.1, 0.1, 0.02, 20);
                        }
                        cancel();
                    } else {
                        event.getItemDrop().setCustomName(hologram.replace("%amount%", event.getItemDrop().getItemStack().getAmount() + "").replace("%time%", deleteTime - counter[0] + ""));
                    }
                    counter[0]++;
                }
            }.runTaskTimer(DropRemover.getInstance(), 0, 20);
        }
    }
}