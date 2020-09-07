package com.spectr3x.enhancedcraft.registry;

import com.spectr3x.enhancedcraft.EnhancedCraft;

import com.spectr3x.enhancedcraft.registry.tools.GiantSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.GiantToolMaterial;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianAxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianPickaxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianShovelItem;

import com.spectr3x.enhancedcraft.registry.tools.ObsidianSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianToolMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item Brewing = new Item (new Item.Settings().group(ItemGroup.BREWING));
    public static final Item Building = new Item (new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item Combat = new Item (new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item Decor = new Item (new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item Food = new Item (new Item.Settings().group(ItemGroup.FOOD));
    public static final Item Materials = new Item (new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item Misc = new Item (new Item.Settings().group(ItemGroup.MISC));
    public static final Item Redstone = new Item (new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item Tools = new Item (new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item Transport = new Item (new Item.Settings().group(ItemGroup.TRANSPORTATION));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "ethereal_gem"), Materials);

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_pickaxe"), new ObsidianPickaxeItem(new ObsidianToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_axe"), new ObsidianAxeItem(new ObsidianToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_shovel"), new ObsidianShovelItem(new ObsidianToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_sword"), new ObsidianSwordItem(new ObsidianToolMaterial()));

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "giant_sword"), new GiantSwordItem(new GiantToolMaterial()));
    }
}