package com.spectr3x.enhancedcraft.registry;

import com.spectr3x.enhancedcraft.EnhancedCraft;

import com.spectr3x.enhancedcraft.registry.tools.GiantSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.GiantToolMaterial;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianAxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianPickaxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianShovelItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianToolMaterial;

import com.spectr3x.enhancedcraft.registry.blocks.EtheriumOreBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModRegistry {

    // Generic Items
    public static final Item GenericBrewing = new Item (new Item.Settings().group(ItemGroup.BREWING));
    public static final Item GenericBuilding = new Item (new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item GenericCombat = new Item (new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item GenericDecor = new Item (new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item GenericFood = new Item (new Item.Settings().group(ItemGroup.FOOD));
    public static final Item GenericMaterials = new Item (new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item GenericMisc = new Item (new Item.Settings().group(ItemGroup.MISC));
    public static final Item GenericRedstone = new Item (new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item GenericTools = new Item (new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item GenericTransport = new Item (new Item.Settings().group(ItemGroup.TRANSPORTATION));

    
    // Block Definitions
    public static final Block EtheriumOreBlock = new EtheriumOreBlock();


    // Item Definitions
    public static final Item Etherium = GenericMaterials;
    public static final Item EtheriumOreItem = new BlockItem(EtheriumOreBlock, new Item.Settings().group(ItemGroup.MISC));
    
    public static final Item ObsidianPickaxeItem = new ObsidianPickaxeItem(new ObsidianToolMaterial());
    public static final Item ObsidianAxeItem = new ObsidianAxeItem(new ObsidianToolMaterial());
    public static final Item ObsidianShovelItem = new ObsidianShovelItem(new ObsidianToolMaterial());
    public static final Item ObsidianSwordItem = new ObsidianSwordItem(new ObsidianToolMaterial());

    public static final Item GiantSwordItem = new GiantSwordItem(new GiantToolMaterial());


    // Ore Generation Definitions
    public static ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      Blocks.WHITE_WOOL.getDefaultState(),
      9)) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      0, // min y level
      64))) // max y level
    .spreadHorizontally()
    .repeat(20); // number of veins per chunk


    // Item Registration Method
    public static void Registry() {

        
        // Item Registry
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium"), Etherium);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreItem);

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_pickaxe"), ObsidianPickaxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_axe"), ObsidianAxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_shovel"), ObsidianShovelItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_sword"), ObsidianSwordItem);

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "giant_sword"), GiantSwordItem);


        // Block Registry
        Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreBlock);
    }
}