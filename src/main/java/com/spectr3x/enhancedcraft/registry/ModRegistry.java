package com.spectr3x.enhancedcraft.registry;

import java.util.Random;

import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumPickaxeItem;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumAxeItem;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumShovelItem;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumHoeItem;
import com.spectr3x.enhancedcraft.registry.tools.EtheriumToolMaterial;
import com.spectr3x.enhancedcraft.registry.tools.GiantSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.GiantToolMaterial;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianSwordItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianPickaxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianAxeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianShovelItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianHoeItem;
import com.spectr3x.enhancedcraft.registry.tools.ObsidianToolMaterial;
import com.spectr3x.enhancedcraft.registry.armor.CustomArmorMaterials;
import com.spectr3x.enhancedcraft.registry.blocks.EtheriumOreBlock;
import com.spectr3x.enhancedcraft.registry.blocks.GemstoneBlock;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
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
    public static Random random;

    
    // Block Definitions
    public static final Block EtheriumOreBlock = new EtheriumOreBlock();
    public static final Block GemstoneBlock = new GemstoneBlock();


    // Item Definitions
    public static final Item Etherium = GenericMaterials;
    public static final Item EtheriumOreItem = new BlockItem(EtheriumOreBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item EtheriumHelmet = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item EtheriumChestplate = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item EtheriumLeggings = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item EtheriumBoots = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item EtheriumSwordItem = new EtheriumSwordItem(new EtheriumToolMaterial());
    public static final Item EtheriumPickaxeItem = new EtheriumPickaxeItem(new EtheriumToolMaterial());
    public static final Item EtheriumAxeItem = new EtheriumAxeItem(new EtheriumToolMaterial());
    public static final Item EtheriumShovelItem = new EtheriumShovelItem(new EtheriumToolMaterial());
    public static final Item EtheriumHoeItem = new EtheriumHoeItem(new EtheriumToolMaterial());

    public static final Item GemstoneBlockItem = new BlockItem(GemstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item GemstoneShard = GenericMaterials;
    public static final Item Gemfuel = GenericMaterials;
    
    public static final Item ObsidianSwordItem = new ObsidianSwordItem(new ObsidianToolMaterial());
    public static final Item ObsidianPickaxeItem = new ObsidianPickaxeItem(new ObsidianToolMaterial());
    public static final Item ObsidianAxeItem = new ObsidianAxeItem(new ObsidianToolMaterial());
    public static final Item ObsidianShovelItem = new ObsidianShovelItem(new ObsidianToolMaterial());
    public static final Item ObsidianHoeItem = new ObsidianHoeItem(new ObsidianToolMaterial());

    public static final Item GiantSwordItem = new GiantSwordItem(new GiantToolMaterial());


    // Ore Generation Definitions
    public static ConfiguredFeature<?, ?> EtheriumOreFeature = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      ModRegistry.EtheriumOreBlock.getDefaultState(),
      2)) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      0, // min y level
      9))) // max y level
    .spreadHorizontally()
    .repeat(2); // number of veins per chunk

    public static ConfiguredFeature<?, ?> GemstoneFeature = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      ModRegistry.EtheriumOreBlock.getDefaultState(),
      MathHelper.nextInt(random, 5, 14))) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      10, // min y level
      27))) // max y level
    .spreadHorizontally()
    .repeat(6); // number of veins per chunk


    // Item Registration Method
    public static void registry() {

        
        // Item Registry
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium"), Etherium);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_helmet"), EtheriumHelmet);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_chestplate"), EtheriumChestplate);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_leggings"), EtheriumLeggings);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_boots"), EtheriumBoots);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_sword"), EtheriumSwordItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_pickaxe"), EtheriumPickaxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_axe"), EtheriumAxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_shovel"), EtheriumShovelItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_hoe"), EtheriumHoeItem);


        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_sword"), ObsidianSwordItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_pickaxe"), ObsidianPickaxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_axe"), ObsidianAxeItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_shovel"), ObsidianShovelItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_hoe"), ObsidianHoeItem);

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "giant_sword"), GiantSwordItem);

        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone"), GemstoneBlockItem);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone_shard"), GemstoneShard);
        Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemfuel"), Gemfuel);


        // Fuel Registry
        FuelRegistry.INSTANCE.add(Gemfuel, 48000);


        // Block Registry
        Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreBlock);
        Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "gemstone"), GemstoneBlock);


        // Structure Generation Registry
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_etherium_overworld"), EtheriumOreFeature);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "Ore_etherium_overworld"), GemstoneFeature);
    }
}