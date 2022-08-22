package com.jeabaplang.betterserver.commands; //Define the current package

import org.bukkit.command.Command; //Import Command
import org.bukkit.command.CommandSender; //Import CommandSender
import org.bukkit.command.CommandExecutor; //Import CommandExecutor

import net.md_5.bungee.api.chat.TextComponent;

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

                TextComponent component = new TextComponent("§4[Aldoria]: " + builder.toString() + "§4");
                Bukkit.broadcast(component);

                return true; //Return true due to command executed
            case "setspawn": //Case setSpawn
                return true; //Return true due to command executed
            default: //If no switch condition
                return false; //Return false due to command not found
        }
    }
}
