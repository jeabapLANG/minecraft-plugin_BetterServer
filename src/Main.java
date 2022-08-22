import org.bukkit.plugin.java.JavaPlugin; //Import JavaPlugin

import com.jeabaplang.betterserver.EventListener;
import com.jeabaplang.betterserver.commands.AdminCommands; //Import AdminCommands
import com.jeabaplang.betterserver.commands.Commands; //Import Commands

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {        
        this.getLogger().info("Plugin enabled");

        this.getCommand("alert").setExecutor(new AdminCommands()); //Set the alert command

        this.getCommand("spawn").setExecutor(new Commands()); //Set the spawn command
        this.getCommand("msg").setExecutor(new Commands()); //Set the spawn command

        this.getServer().getPluginManager().registerEvents(new EventListener(), this); //Add a listener to the server events
    }

    @Override 
    public void onDisable() {
        this.getLogger().info("Plugin disabled");
    }
}
