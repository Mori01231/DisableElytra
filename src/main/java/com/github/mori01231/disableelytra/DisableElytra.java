package com.github.mori01231.disableelytra;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class DisableElytra extends JavaPlugin {


    private static DisableElytra instance;

    public DisableElytra (){
        instance = this;
    }

    public static DisableElytra getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("DisableElytra has been enabled.");

        registerEvents();

        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("DisableElytra has been disabled.");
    }

    public void registerEvents(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new ElytraListener(this),  this);
    }
}
