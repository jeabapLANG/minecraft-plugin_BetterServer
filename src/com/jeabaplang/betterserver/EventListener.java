package com.jeabaplang.betterserver; //Define the current package

import org.bukkit.event.Listener; //Import Listener
import org.bukkit.event.EventHandler; //Import EventHandler

import org.bukkit.event.player.PlayerJoinEvent; //Import PlayerJoinEvent
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.event.player.PlayerInteractEvent; //Import PlayerInteractEvent

import org.bukkit.Bukkit; //Import Bukkit
import org.bukkit.ChatColor;
import org.bukkit.entity.Player; //Import Player

import com.jeabaplang.betterserver.modules.environment.Harvest; //Import Harvest

import net.kyori.adventure.text.Component;
import io.papermc.paper.event.player.AsyncChatEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        System.out.println("event");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("§a[BetterServer]: Join event triggered !§a");

        event.joinMessage(null);; //Disable the join message

        final Player player = event.getPlayer(); //Get the player

        player.sendMessage("§9[Aldoria]: Bienvenue sur le serveur " + player.getName() + " !§9"); //Send the welcome message to the player

        final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        final Objective objective = scoreboard.registerNewObjective("sidebar", "Statistiques", Component.text("EST")); //name, criteria, displayName (name showed on top of sidebar)
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        final Score quests = objective.getScore(ChatColor.GREEN + "Quetes");
        final Score golds = objective.getScore(ChatColor.GREEN + "Pieces d'or");

        quests.setScore(34);
        golds.setScore(5000);

        player.setScoreboard(scoreboard);

        //player.playerListHeader().
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return; //Return if no item handled by the player

        Harvest.onEvent(event); //Calling Harvest module
    }
}
