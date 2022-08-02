package com.github.jeabaplang.betterserver.commands; //Define the current package

import org.bukkit.command.Command; //Import Command
import org.bukkit.command.CommandSender; //Import CommandSender
import org.bukkit.command.CommandExecutor; //Import CommandExecutor

import org.bukkit.entity.Player; //Import Player

import org.bukkit.Location; //Import Location

import org.bukkit.Bukkit; //Import Bukkit

public class Commands implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String message, String[] arguments) {
        System.out.println("§a[BetterServer]: Normal command event triggered !§a");

        if(sender instanceof Player) { //If the sender of the command is a player
            Player player = (Player)sender; //Get the player entity from the sender

            switch(command.getName()) { //Process the command name
                case "spawn": //Case alert
                    Location currentCoordinates = player.getLocation(); //Get the current player coordinates
                    Location spawnCoordinates = new Location(Bukkit.getWorld("world"), 93, 63, 192, -85, -3); //Coordinates of the spawn

                    player.sendMessage(currentCoordinates.toString());

                    player.teleport(spawnCoordinates); //Teleport the player to the spawn
                    player.sendMessage("§e[Aldoria]: Vous venez d'etre teleporte au point d'apparition !§e"); //Alert the player that the teleportation worked

                    return true; //Return true due to command executed          
                default: //If no switch condition
                    return false; //Return false due to command not found
            }
        }

        return false; //Return false due to command not found
    }
}
