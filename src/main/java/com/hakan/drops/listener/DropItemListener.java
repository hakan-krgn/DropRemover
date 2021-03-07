package com.hakan.drops.listener;

import com.hakan.drops.DropRemover;
import com.hakan.drops.utils.Variables;
import com.hakan.particle.Particle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DropItemListener implements Listener {

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        if (Variables.isActive) {

            int deleteTime = Variables.removeTime;
            String hologram = ChatColor.translateAlternateColorCodes('&', Variables.hologram.replace("%material%", event.getItemDrop().getItemStack().getType().name()));

            Item itemDrop = event.getItemDrop();
            itemDrop.setCustomNameVisible(true);
            itemDrop.setCustomName(hologram.replace("%amount%", itemDrop.getItemStack().getAmount() + "").replace("%time%", deleteTime + ""));

            new BukkitRunnable() {
                int counter = 0;

                public void run() {
                    if (itemDrop.isDead()) {
                        cancel();
                        return;
                    } else if (counter >= deleteTime) {
                        itemDrop.remove();
                        if (Variables.effectActive) {
                            Variables.particleAPI.sendAll(event.getItemDrop().getLocation(), new Particle(Variables.effect, 20, 0.02, new Vector(0.1, 0.1, 0.1)));
                        }
                        cancel();
                        return;
                    } else {
                        itemDrop.setCustomName(hologram.replace("%amount%", itemDrop.getItemStack().getAmount() + "").replace("%time%", (deleteTime - counter) + ""));
                    }
                    counter++;
                }
            }.runTaskTimer(DropRemover.getInstance(), 0, 20);
        }
    }
}