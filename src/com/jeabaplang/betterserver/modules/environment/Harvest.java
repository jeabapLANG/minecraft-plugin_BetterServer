package com.jeabaplang.betterserver.modules.environment; //Define the current package

import org.bukkit.event.block.Action; //Import Action
import org.bukkit.entity.Player; //Import Player

import org.bukkit.inventory.ItemStack; //Import ItemStack
import org.bukkit.block.Block; //Import block
import org.bukkit.event.player.PlayerInteractEvent; //Import PlayerInteractEvent

import com.jeabaplang.betterserver.modules.environment.tools.Tool; //Import Tool
import com.jeabaplang.betterserver.modules.environment.environments.Plant; //Import Plant
import com.jeabaplang.betterserver.modules.environment.tools.Harvester; //Import Harvester

public class Harvest {
    public static void onEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer(); //Get the player
        Action action = event.getAction(); //Get the action

        ItemStack item = event.getItem(); //Get the item in hand
        Block target = event.getClickedBlock();
        
        if(Tool.isHarvestingTool(item.getType())) {           
            if(action.equals(Action.RIGHT_CLICK_BLOCK)) {
                if(Plant.isHarvestable(target.getType()) == true) {               
                    Harvester harvester = new Harvester(item, player, target);
                    harvester.applyEffect();
                }
            }
        }
    }
}
