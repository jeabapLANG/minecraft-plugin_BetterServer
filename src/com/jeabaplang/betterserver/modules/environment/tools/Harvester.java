package com.jeabaplang.betterserver.modules.environment.tools; //Define the current package

import org.bukkit.Location; //Import Location

import org.bukkit.entity.Player; //Import Player
import org.bukkit.inventory.PlayerInventory; //Import PlayerInventory

import org.bukkit.inventory.ItemStack; //Import ItemStack
import org.bukkit.Material; //Import Material
import org.bukkit.Sound; //Import Sound
import org.bukkit.block.Block; //Import Block
import org.bukkit.block.data.Ageable; //Import Ageable
import org.bukkit.inventory.meta.Damageable; //Import Damageable
import org.bukkit.inventory.meta.ItemMeta; //Import ItemMeta

import com.jeabaplang.betterserver.modules.environment.environments.Plant; //Import Plant

public final class Harvester extends Tool {
    private final short _actionRadius;

    public Harvester(ItemStack item, Player player, Block target) {
        super(item, player, target);

        this._actionRadius = Harvester.getRadius(this._material);
    }

    public short getActionRadius() {
        return this._actionRadius;
    }

    public void applyEffect() {
        Ageable age = (Ageable)this._target.getBlockData();
                    
        if(age.getAge() == age.getMaximumAge()) {
            PlayerInventory inventory = this._player.getInventory();
            Location targetCoordinates = this._target.getLocation();

            ItemMeta informations = this._item.getItemMeta();  
            Damageable damageable = (Damageable)informations;  

            for(double x = targetCoordinates.getX() - this._actionRadius; x <= targetCoordinates.getX() + this._actionRadius; x++) {
                if((informations.isUnbreakable() == false) && (damageable.getDamage() == this._item.getType().getMaxDurability())) break;

                for(double z = targetCoordinates.getZ() - this._actionRadius; z <= targetCoordinates.getZ() + this._actionRadius; z++) {
                    Block block = (new Location(this._player.getWorld(), x, targetCoordinates.getY(), z)).getBlock();
                    Plant plant = new Plant(block.getType());

                    if(block.getType() == this._target.getType()) {
                        if((informations.isUnbreakable() == false) && (damageable.getDamage() == this._item.getType().getMaxDurability())) break;

                        Ageable ageable = (Ageable)block.getBlockData();

                        if(ageable.getAge() == ageable.getMaximumAge()) {
                            if(inventory.contains(plant.getSeed()) == true) {
                                block.breakNaturally();
                                this._player.getWorld().playSound(block.getLocation(), Sound.ITEM_HOE_TILL, 1F, 1F);
                                inventory.remove(new ItemStack(plant.getSeed(), 1));
                                block.setType(plant.getMaterial());
                            }

                            damageable.setDamage(damageable.getDamage() + 1);
                        }
                    }
                }
            }

            if(informations.isUnbreakable() == false) {
                if(damageable.getDamage() == this._item.getType().getMaxDurability()) {
                    this.destroy();
                } else {
                    this._item.setItemMeta((ItemMeta)damageable);
                }
            }
        }
    }

    public static final short getRadius(Material material) {
        short actionRadius;

        //TODO: Modification possible du switch en array 

        switch(material) {
            case WOODEN_HOE:
                actionRadius = 2;
                break;
            case STONE_HOE:
                actionRadius = 3;
                break;
            case IRON_HOE:
                actionRadius = 4;
                break;
            case GOLDEN_HOE:
                actionRadius = 6;
                break;
            case DIAMOND_HOE:
                actionRadius = 8;
                break;

            default:
                actionRadius = 12;
                break;
        }

        return actionRadius;
    }
}
