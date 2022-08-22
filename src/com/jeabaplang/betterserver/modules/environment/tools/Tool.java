package com.jeabaplang.betterserver.modules.environment.tools; //Define the current package

import org.bukkit.entity.Player; //Import Player

import org.bukkit.inventory.ItemStack; //Import ItemStack
import org.bukkit.Material; //Import Material
import org.bukkit.Sound;
import org.bukkit.block.Block; //Import Block

import com.jeabaplang.betterserver.modules.environment.types.LoggerType; //Import LoggerType
import com.jeabaplang.betterserver.modules.environment.types.HarvesterType; //Import HarvesterType

public abstract class Tool {
    public final Material _material;

    public final ItemStack _item;
    public final Player _player;
    public final Block _target;

    Tool(ItemStack item, Player player, Block target) {
        this._item = item;
        this._player = player;
        this._target = target;

        this._material = item.getType();
    }

    public void destroy() {
        this._player.getInventory().remove(this._item); //Remove the item from the player inventory
        this._player.playSound(this._player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F); //Play the item break sound
    }

    public static final boolean isLoggingTool(Material material) {
        boolean logging;

        switch(material) {
            case WOODEN_AXE:
                logging = true;
                break;
            case STONE_AXE:
                logging = true;
                break;
            case IRON_AXE:
                logging = true;
                break;
            case GOLDEN_AXE:
                logging = true;
                break;
            case DIAMOND_AXE:
                logging = true;
                break;
            case NETHERITE_AXE:
                logging = true;
                break;

            default:
                logging = false;
                break;
        }

        return logging;
    }

    public static final boolean isHarvestingTool(Material material) {
        boolean harvesting;

        switch(material) {
            case WOODEN_HOE:
                harvesting = true;
                break;
            case STONE_HOE:
                harvesting = true;
                break;
            case IRON_HOE:
                harvesting = true;
                break;
            case GOLDEN_HOE:
                harvesting = true;
                break;
            case DIAMOND_HOE:
                harvesting = true;
                break;
            case NETHERITE_HOE:
                harvesting = true;
                break;

            default:
                harvesting = false;
                break;
        }

        return harvesting;
    }

    public static final LoggerType getLoggingType(Material material) {
        LoggerType type;

        switch(material) {
            case WOODEN_AXE:
                type = LoggerType.WOODEN_AXE;
                break;
            case STONE_AXE:
                type = LoggerType.STONE_AXE;
                break;
            case IRON_AXE:
                type = LoggerType.IRON_AXE;
                break;
            case GOLDEN_AXE:
                type = LoggerType.GOLDEN_AXE;
                break;
            case DIAMOND_AXE:
                type = LoggerType.DIAMOND_AXE;
                break;

            default:
                type = LoggerType.NETHERITE_AXE;
                break;
        }

        return type;
    }

    public static final HarvesterType getHarvestingType(Material material) {
        HarvesterType type;

        switch(material) {
            case WOODEN_HOE:
                type = HarvesterType.WOODEN_HOE;
                break;
            case STONE_HOE:
                type = HarvesterType.STONE_HOE;
                break;
            case IRON_HOE:
                type = HarvesterType.IRON_HOE;
                break;
            case GOLDEN_HOE:
                type = HarvesterType.GOLDEN_HOE;
                break;
            case DIAMOND_HOE:
                type = HarvesterType.DIAMOND_HOE;
                break;

            default:
                type = HarvesterType.NETHERITE_HOE;
                break;
        }

        return type;
    }
}
