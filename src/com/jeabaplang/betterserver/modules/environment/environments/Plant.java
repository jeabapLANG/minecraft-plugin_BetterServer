package com.jeabaplang.betterserver.modules.environment.environments; //Define the current package

import org.bukkit.Material; //Import Material

import com.jeabaplang.betterserver.modules.environment.materials.HarvestableMaterial; //Import Harvestable

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

    public static final HarvestableMaterial getHarvestable(Material material) {
        HarvestableMaterial harvestable;

        switch(material) {
            case WHEAT: 
                harvestable = HarvestableMaterial.WHEAT;
                break;     
            case BEETROOTS:
                harvestable = HarvestableMaterial.BEETROOT;
                break;     
            case CARROTS:
                harvestable = HarvestableMaterial.CARROT;
                break;     
            case POTATOES:
                harvestable = HarvestableMaterial.POTATO;
                break;     
            case MELON:
                harvestable = HarvestableMaterial.MELON;
                break;     
            case PUMPKIN:
                harvestable = HarvestableMaterial.PUMPKIN;
                break;     
            case BAMBOO: 
                harvestable = HarvestableMaterial.BAMBOO;
                break;     
            case SUGAR_CANE:
                harvestable = HarvestableMaterial.SUGAR_CANE;
                break;     
            case SWEET_BERRIES:
                harvestable = HarvestableMaterial.SWEET_BERRY_BUSH;
                break;     
            case CACTUS:
                harvestable = HarvestableMaterial.CACTUS;
                break;     
            case KELP:
                harvestable = HarvestableMaterial.KELP;
                break;     
            default:
                harvestable = HarvestableMaterial.NETHER_WART;
                break;     
        }

        return harvestable;
    }

    public static final Material getSeed(HarvestableMaterial harvestable) {
        Material material;

        switch(harvestable) {
            case WHEAT: 
                material = Material.WHEAT_SEEDS;
                break;     
            case BEETROOT:
                material = Material.BEETROOT_SEEDS;
                break;
            case CARROT:
                material = Material.CARROT;
                break;
            case POTATO:
                material = Material.POTATO;
                break;
            case MELON:
                material = Material.MELON_SEEDS;
                break;
            case PUMPKIN:
                material = Material.PUMPKIN_SEEDS;
                break;
            case BAMBOO: 
                material = Material.BAMBOO;
                break;
            case SUGAR_CANE:
                material = Material.SUGAR_CANE;
                break;
            case SWEET_BERRY_BUSH:
                material = Material.SWEET_BERRIES;
                break;
            case CACTUS:
                material = Material.CACTUS;
                break;
            case KELP:
                material = Material.KELP;
                break;
            default:
                material = Material.NETHER_WART;
                break;
        }

        return material;
    }
}
