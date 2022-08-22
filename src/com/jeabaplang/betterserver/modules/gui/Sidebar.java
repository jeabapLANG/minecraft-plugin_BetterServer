package com.jeabaplang.betterserver.modules.gui; //Define the current package

import org.bukkit.entity.Player; //Import Player

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

import net.kyori.adventure.text.Component;

import org.bukkit.Bukkit; //Import Bukkit

public class Sidebar {
    private String _title;

    private final Scoreboard _handler;
    private final Objective _displayable;

    public Sidebar(String title) {
        this._title = title;
        this._handler = Bukkit.getScoreboardManager().getNewScoreboard();
        this._displayable = this._handler.registerNewObjective("sidebar", title, Component.text(title));
        this._displayable.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public String getTitle() {
        return this._title;
    }
    public Scoreboard getHandler() {
        return this._handler;
    }

    public void addSlot(String name, int value) {
        final Score line = this._displayable.getScore(name);
        line.setScore(value);
    }

    public int getSlot(String name) {
        return this._displayable.getScore(name).getScore();
    }

    public void bind(Player player) {
        player.setScoreboard(this.getHandler());
    }
}
