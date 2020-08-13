package com.github.mori01231.disableelytra;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerTeleportEvent;


public class ElytraListener implements Listener {

    private DisableElytra plugin;
    public ElytraListener(DisableElytra plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onToggleGlideEvent(EntityToggleGlideEvent event) {
        if (event.getEntity().getType().equals(EntityType.PLAYER)){
            for (String line : DisableElytra.getInstance().getConfig().getStringList("ElytraBannedWorlds")) {
                if(event.getEntity().getWorld().getName().equalsIgnoreCase(line)){
                    if(event.isGliding()) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleportEvent(PlayerTeleportEvent event){
        for (String line : DisableElytra.getInstance().getConfig().getStringList("ElytraBannedWorlds")) {
            if(event.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase(line)){
                event.getPlayer().setGliding(false);
            }
        }
    }
}
