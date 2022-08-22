package com.jeabaplang.betterserver.commands; //Define the current package

import org.bukkit.command.Command; //Import Command
import org.bukkit.command.CommandSender; //Import CommandSender
import org.bukkit.command.CommandExecutor; //Import CommandExecutor

import org.bukkit.entity.Player; //Import Player
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

import org.bukkit.Location; //Import Location
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Note.Tone;
import org.bukkit.Bukkit; //Import Bukkit
import org.bukkit.Instrument;

public class Commands implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String message, String[] arguments) {
        System.out.println("§a[BetterServer]: Normal command event triggered !§a");

        if(sender instanceof Player) { //If the sender of the command is a player
            Player player = (Player)sender; //Get the player entity from the sender

            switch(command.getName()) { //Process the command name
                case "spawn": //Case alert                    
                    Location spawnCoordinates = new Location(Bukkit.getWorld("world"), 93D, 63D, 192D, -85F, -3F); //Coordinates of the spawn

                    BukkitRunnable countdown = new BukkitRunnable() {
                        private short timer = 5;

                        @Override
                        public void run() {
                            if(timer == 0) {
                                this.cancel();

                                player.teleport(spawnCoordinates); //Teleport the player to the spawn
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
                                
                                sender.sendMessage("§e[Aldoria]: Vous venez d'etre teleporte au point d'apparition !§e"); //Alert the player that the teleportation worked
                            } else if(timer == 1) {
                                player.playNote(player.getLocation(), Instrument.CHIME, Note.sharp(1, Tone.G));
                            } else if(timer > 1) {
                                player.playNote(player.getLocation(), Instrument.PLING, Note.sharp(2, Tone.F));
                            }

                            timer--;
                        }
                    };

                    countdown.runTaskTimer(Bukkit.getPluginManager().getPlugin("BetterServer"), 0L, 20L);

                    return true; //Return true due to command executed
                case "msg":
                    TextComponent component = new TextComponent("Discord link:");
                    component.setFont("minecraft:uniform");

                    component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new Text("Cliquez sur ce lien")));
                    component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "discord.com"));
                    sender.sendMessage(component);
                    return true;
                    
                default: //If no switch condition
                    return false; //Return false due to command not found
            }
        }

        return false; //Return false due to command not found
    }
}
