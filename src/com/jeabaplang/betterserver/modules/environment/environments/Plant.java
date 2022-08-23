package com.jeabaplang.betterserver.modules.environment.environments; //Define the current package

import org.bukkit.Material; //Import Material

import com.jeabaplang.betterserver.modules.environment.materials.HarvestableMaterial; //Import Harvestable

import java.util.EnumMap;
import java.util.Map;

public final class Plant {
    private final Material _material;
    private final HarvestableMaterial _type;
    private final Material _seed;

    public Plant(Material material) {
        this._material = material;
        this._type = Plant.getHarvestable(material);
        this._seed = Plant.getSeed(this.getType());
    }

    public final Material getMaterial() {
        return this._material;
    }
    
    public final HarvestableMaterial getType() {
        return this._type;
    }

    public final Material getSeed() {
        return this._seed;
    }

    public static final boolean isHarvestable(Material material) {
        boolean harvestable;

        switch(material) {
            case WHEAT:
                harvestable = true;
                break;
            case BEETROOTS:
                harvestable = true;
                break;
            case CARROTS:
                harvestable = true;
                break;
            case POTATOES:
                harvestable = true;
                break;
            case MELON:
                harvestable = true;
                break;
            case PUMPKIN:
                harvestable = true;
                break;
            case BAMBOO:
                harvestable = true;
                break;
            case SUGAR_CANE:
                harvestable = true;
                break;
            case SWEET_BERRIES:
                harvestable = true;
                break;
            case CACTUS:
                harvestable = true;
                break;
            case KELP: 
                harvestable = true;
                break;  
            case NETHER_WART:
                harvestable = true;
                break;
            default:
                harvestable = false;
                break;
        }

        return harvestable;
    }

    private static final Map<Material, HarvestableMaterial> harvestables = new EnumMap<>(Map.ofEntries(
        Map.entry(Material.WHEAT, HarvestableMaterial.WHEAT),
        Map.entry(Material.BEETROOTS, HarvestableMaterial.BEETROOT),
        Map.entry(Material.CARROTS, HarvestableMaterial.CARROT),
        Map.entry(Material.POTATOES, HarvestableMaterial.POTATO),
        Map.entry(Material.MELON, HarvestableMaterial.MELON),
        Map.entry(Material.PUMPKIN, HarvestableMaterial.PUMPKIN),
        Map.entry(Material.BAMBOO, HarvestableMaterial.BAMBOO),
        Map.entry(Material.SUGAR_CANE, HarvestableMaterial.SUGAR_CANE),
        Map.entry(Material.SWEET_BERRIES, HarvestableMaterial.SWEET_BERRY_BUSH),
        Map.entry(Material.CACTUS, HarvestableMaterial.CACTUS),
        Map.entry(Material.KELP, HarvestableMaterial.KELP),
        Map.entry(Material.NETHER_WART, HarvestableMaterial.NETHER_WART)
    ));

    public static final HarvestableMaterial getHarvestable(Material material) {
        return Plant.harvestables.containsKey(material) ? Plant.harvestables.get(material) : HarvestableMaterial.NETHER_WART;
    }

    private static final Map<HarvestableMaterial, Material> seeds = new EnumMap<>(Map.ofEntries(
        Map.entry(HarvestableMaterial.WHEAT, Material.WHEAT_SEEDS),
        Map.entry(HarvestableMaterial.BEETROOT, Material.BEETROOT_SEEDS),
        Map.entry(HarvestableMaterial.CARROT, Material.CARROT),
        Map.entry(HarvestableMaterial.POTATO, Material.POTATO),
        Map.entry(HarvestableMaterial.MELON, Material.MELON_SEEDS),
        Map.entry(HarvestableMaterial.PUMPKIN, Material.PUMPKIN_SEEDS),
        Map.entry(HarvestableMaterial.BAMBOO, Material.BAMBOO),
        Map.entry(HarvestableMaterial.SUGAR_CANE, Material.SUGAR_CANE),
        Map.entry(HarvestableMaterial.SWEET_BERRY_BUSH, Material.SWEET_BERRIES),
        Map.entry(HarvestableMaterial.CACTUS, Material.CACTUS),
        Map.entry(HarvestableMaterial.KELP, Material.KELP),
        Map.entry(HarvestableMaterial.NETHER_WART, Material.NETHER_WART)
    ));

    public static final Material getSeed(HarvestableMaterial harvestable) {
        return Plant.seeds.containsKey(harvestable) ? Plant.seeds.get(harvestable) : Material.NETHER_WART;
    }
}
