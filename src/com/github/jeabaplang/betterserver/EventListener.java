package com.github.jeabaplang.betterserver; //Define the current package

import org.bukkit.event.Listener; //Import Listener
import org.bukkit.event.EventHandler; //Import EventHandler
import org.bukkit.event.player.PlayerJoinEvent; //Import PlayerJoinEvent

import org.bukkit.inventory.ItemStack; //Import ItemStack
import org.bukkit.Material; //Import Material

import org.bukkit.event.player.PlayerInteractEvent; //Import PlayerInteractEvent
import org.bukkit.event.block.Action;

import org.bukkit.entity.Player; //Import Player

public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        System.out.println("§a[BetterServer]: Join event triggered !§a");

        event.setJoinMessage(""); //Disable the join message

        Player player = event.getPlayer(); //Get the player

        player.sendMessage("§9[Aldoria]: Bienvenue sur le serveur " + player.getDisplayName() + " !§9"); //Send the welcome message to the player
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer(); //Get the player
        Action action = event.getAction(); //Get the action

        ItemStack item = event.getItem(); //Get the item

        if(item.getType() == Material.DIAMOND_AXE) {
            player.sendMessage("Vous venez de definir la position 1");
        }
    }
}
