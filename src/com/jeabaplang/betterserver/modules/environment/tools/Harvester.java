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

import it.unimi.dsi.fastutil.ints.Int2BooleanFunctions;

import java.util.EnumMap;
import java.util.Map;

public final class Harvester extends Tool {
    private final Integer _actionRadius;

    public Harvester(ItemStack item, Player player, Block target) {
        super(item, player, target);

        this._actionRadius = Harvester.getRadius(this._material);
    }

    public Integer getActionRadius() {
        return this._actionRadius;
    }

    public void applyEffect() {
        Ageable age = (Ageable)this._target.getBlockData();

        if(age.getAge() != age.getMaximumAge()) {
            return;
        }
                    
        PlayerInventory inventory = this._player.getInventory();
        Location targetCoordinates = this._target.getLocation();

        ItemMeta informations = this._item.getItemMeta();  
        Damageable damageable = (Damageable)informations;  

        for(double x = targetCoordinates.getX() - this._actionRadius; x <= targetCoordinates.getX() + this._actionRadius; x++) {
            if(!informations.isUnbreakable() && (damageable.getDamage() == this._item.getType().getMaxDurability())) break;

            for(double z = targetCoordinates.getZ() - this._actionRadius; z <= targetCoordinates.getZ() + this._actionRadius; z++) {
                Block block = (new Location(this._player.getWorld(), x, targetCoordinates.getY(), z)).getBlock();
                Plant plant = new Plant(block.getType());

                if(block.getType() == this._target.getType()) {
                    if(!informations.isUnbreakable() && (damageable.getDamage() == this._item.getType().getMaxDurability())) break;

                    Ageable ageable = (Ageable)block.getBlockData();

                    if(ageable.getAge() == ageable.getMaximumAge()) {
                        if(inventory.contains(plant.getSeed())) {
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

        if(!informations.isUnbreakable()) {
            if(damageable.getDamage() == this._item.getType().getMaxDurability()) {
                this.destroy();
            } else {
                this._item.setItemMeta((ItemMeta)damageable);
            }
        }
    }

    private static final Map<Material, Integer> hoeActionRadius = new EnumMap<>(Map.ofEntries(
        Map.entry(Material.WOODEN_HOE, 2),
        Map.entry(Material.STONE_HOE, 3),
        Map.entry(Material.IRON_HOE, 4),
        Map.entry(Material.GOLDEN_HOE, 6),
        Map.entry(Material.DIAMOND_HOE, 8),
        Map.entry(Material.NETHERITE_HOE, 12)
    ));

    public static final Integer getRadius(Material material) {
        return Harvester.hoeActionRadius.containsKey(material) ? Harvester.hoeActionRadius.get(material) : 12;
    }
}
