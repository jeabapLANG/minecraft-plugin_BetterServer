package com.github.jeabaplang.betterserver.commands; //Define the current package

import java.util.Arrays; //Import Arrays

import org.bukkit.command.Command; //Import Command
import org.bukkit.command.CommandSender; //Import CommandSender
import org.bukkit.command.CommandExecutor; //Import CommandExecutor

import org.bukkit.inventory.ItemStack; //Import ItemStack
import org.bukkit.inventory.meta.ItemMeta; //Import ItemMeta
import org.bukkit.inventory.ItemFlag; //Import ItemFlag
import org.bukkit.Material; //Import Material

import org.bukkit.enchantments.Enchantment; //Import Enchantment

import org.bukkit.entity.Player; //Import Player

import org.bukkit.Bukkit; //Import Bukkit

public class AdminCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String message, String[] arguments) {
        System.out.println("§a[BetterServer]: Admin command event triggered !§a");

        switch(command.getName()) { //Process the command name
            case "alert": //Case alert
                if(arguments.length < 1) { //If no message passed
                    sender.sendMessage("§cVeuillez specifier un message: /alert <message>§c"); //Send a message to remember the command format

                    return false; //Return false due to command not executed
                }

                StringBuilder builder = new StringBuilder(); //Create a string builer

                for(String part : arguments) { //For each part of the message
                    builder.append(part + " "); //Build the broadcast message
                }

                Bukkit.broadcastMessage("§4[Aldoria]: " + builder.toString() + "§4"); //Send the server alert

                return true; //Return true due to command executed
            case "setspawn": //Case setSpawn
                return true; //Return true due to command executed

            case "giveeditor": //Case giveWorldEditor
                if(sender instanceof Player) { //If the sender of the command is a player
                    Player player = (Player)sender; //Get the player entity from the sender

                    ItemStack worldEditor = new ItemStack(Material.DIAMOND_AXE, 1); //Create an axe item
                    ItemMeta informations = worldEditor.getItemMeta(); //Get the axe informations

                    informations.setDisplayName("Editeur de monde"); //Set the world editor item name
                    informations.setLore(Arrays.asList("Clic droit pour definir le point 2", "Clic gauche pour definir le point 1"));

                    informations.setUnbreakable(true); //Set the world editor item as unbreakable

                    informations.addEnchant(Enchantment.DIG_SPEED, 10000, true); //Add instant breack to worldEditor item

                    informations.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //Hide the worldEditor attributes
                    informations.addItemFlags(ItemFlag.HIDE_DESTROYS); //Hide the worldEditor destroyable items
                    informations.addItemFlags(ItemFlag.HIDE_DYE); //Hide the worldEditor destroyable items
                    informations.addItemFlags(ItemFlag.HIDE_ENCHANTS); //Hide the worldEditor enchants
                    informations.addItemFlags(ItemFlag.HIDE_PLACED_ON); //Hide the worldEditor fabrication
                    informations.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS); //Hide the worldEditor potion effects
                    informations.addItemFlags(ItemFlag.HIDE_UNBREAKABLE); //Hide the worldEditor unbreakable status

                    worldEditor.setItemMeta(informations); //Set the worldEditor item informations

                    player.getInventory().setItemInMainHand(worldEditor); //Set the worldEditor item in the main hand
                    player.updateInventory(); //Update the player inventory
    
                    return true; //Return true due to command executed
                }
                
                return false; //Return false due to command not found
            default: //If no switch condition
                return false; //Return false due to command not found
        }
    }
}
