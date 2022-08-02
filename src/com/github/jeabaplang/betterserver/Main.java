package com.github.jeabaplang.betterserver; //Define the current package

import org.bukkit.plugin.java.JavaPlugin; //Import JavaPlugin

import com.github.jeabaplang.betterserver.commands.AdminCommands; //Import AdminCommands
import com.github.jeabaplang.betterserver.commands.Commands; //Import Commands

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getLogger().info("§a" + this.getDescription().getName() + "Plugin enabled !§a");
        
        this.getCommand("alert").setExecutor(new AdminCommands()); //Set the alert command
        this.getCommand("giveeditor").setExecutor(new AdminCommands()); //Set the giveWorldEditor command

        this.getCommand("spawn").setExecutor(new Commands()); //Set the spawn command

        this.getServer().getPluginManager().registerEvents(new EventListener(), this); //Add a listener to the server events
    }

    @Override 
    public void onDisable() {
        this.getLogger().info("§a[" + this.getDescription().getName() + "]: Plugin disabled !§a");
    }
}
