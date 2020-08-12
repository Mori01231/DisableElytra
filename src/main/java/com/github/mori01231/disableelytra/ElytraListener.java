package com.github.mori01231.disableelytra;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class ElytraListener implements Listener {

    private DisableElytra plugin;
    public ElytraListener(DisableElytra plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onToggleGlideEvent(EntityToggleGlideEvent event) {
        if (event.getEntity().getType().equals(EntityType.PLAYER)){
            try{
                for (String line : DisableElytra.getInstance().getConfig().getStringList("ElytraBannedWorlds")) {
                    if(event.getEntity().getWorld().toString().equalsIgnoreCase(line)){
                        event.setCancelled(true);
                    }
                }
            }catch (Exception e){
            }
        }
    }
}
