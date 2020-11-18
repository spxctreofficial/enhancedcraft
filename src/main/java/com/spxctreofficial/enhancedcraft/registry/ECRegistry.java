package com.spxctreofficial.enhancedcraft.registry;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.registry.enchantments.HarvesterEnchantment;
import com.spxctreofficial.enhancedcraft.registry.entity.HeroBrineEntity;
import com.spxctreofficial.enhancedcraft.registry.entity.SmartPearlEntity;
import com.spxctreofficial.enhancedcraft.registry.misc.FireballItem;
import com.spxctreofficial.enhancedcraft.registry.statusEffects.DeteriorationStatusEffect;
import com.spxctreofficial.enhancedcraft.registry.tools.*;

import com.spxctreofficial.enhancedcraft.registry.armor.CustomArmorMaterials;
import com.spxctreofficial.enhancedcraft.registry.blocks.*;
import com.spxctreofficial.enhancedcraft.registry.foodstuffs.*;
import com.spxctreofficial.enhancedcraft.registry.misc.*;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ECRegistry {
	/*
	    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    	}

    	cool guy i509VCB advice
	 */


	// SoundEvents Definitions
	public static final Identifier SOAKED_HANDS = new Identifier("enhancedcraft:soaked_hands");

	public static final Identifier ETHERIUM_ENRAGED_SOUND = new Identifier("enhancedcraft:etherium_enraged_sound");
	public static final Identifier ETHERIUM_ENRAGED_KILL = new Identifier("enhancedcraft:etherium_enraged_kill");
	public static final Identifier ETHERIUM_ENRAGED_ENDED_SOUND = new Identifier("enhancedcraft:etherium_enraged_ended_sound");

	public static final Identifier SMART_PEARL_THROW = new Identifier("enhancedcraft:smart_pearl_throw");
	public static final Identifier SMART_PEARL_TELEPORT = new Identifier("enhancedcraft:smart_pearl_teleport");

	public static SoundEvent soakedHandsSoundEvent = new SoundEvent(SOAKED_HANDS);

	public static SoundEvent etheriumEnragedSoundEvent = new SoundEvent(ETHERIUM_ENRAGED_SOUND);
	public static SoundEvent etheriumEnragedKillSoundEvent = new SoundEvent(ETHERIUM_ENRAGED_KILL);
	public static SoundEvent etheriumEnragedEndedSoundEvent = new SoundEvent(ETHERIUM_ENRAGED_ENDED_SOUND);

	public static SoundEvent smartPearlThrowSoundEvent = new SoundEvent(SMART_PEARL_THROW);
	public static SoundEvent smartPearlTeleportSoundEvent = new SoundEvent(SMART_PEARL_TELEPORT);

	// Block Definitions
	public static final Block OTHERSTONE_BLOCK = new OtherstoneBlock();
	public static final Block EARTHSTONE_BLOCK = new EarthstoneBlock();

	public static final Block ETHERIUM_ORE_BLOCK = new EtheriumOreBlock();
	public static final Block BRONZE_ORE_BLOCK = new BronzeOreBlock();
	public static final Block GEMSTONE_BLOCK = new GemstoneBlock();
	public static final Block COBALT_ORE_BLOCK = new CobaltOreBlock();
	public static final Block FORTISTEEL_EARTHSTONE_BLOCK = new FortisteelEarthstoneBlock();
	public static final Block FORTISTEEL_OTHERSTONE_BLOCK = new FortisteelOtherstoneBlock();
	public static final Block PURIGOLD_EARTHSTONE_BLOCK = new PurigoldEarthstoneBlock();
	public static final Block PURIGOLD_OTHERSTONE_BLOCK = new PurigoldOtherstoneBlock();

	public static final Block ETHERIUM_BLOCK = new EtheriumBlock();
	public static final Block BRONZE_BLOCK = new BronzeBlock();

	public static final Block GOLDEN_HEAD_BLOCK = new SkullBlock(CustomSkullType.GOLDEN_HEAD, AbstractBlock.Settings.of(Material.SUPPORTED).strength(1.0F)) {};
	public static final Block GOLDEN_HEAD_WALL_BLOCK = new WallSkullBlock(CustomSkullType.GOLDEN_HEAD, AbstractBlock.Settings.of(Material.SUPPORTED).strength(1.0F).dropsLike(GOLDEN_HEAD_BLOCK)) {};

	// Item Definitions
	public static final Item ETHERIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.EPIC));
	public static final Item ETHERIUM_ORE_ITEM = new BlockItem(ETHERIUM_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ETHERIUM_BLOCK_ITEM = new BlockItem(ETHERIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item ETHERIUM_HELMET = new ArmorItem(CustomArmorMaterials.ETHERIUM_ARMOR, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ETHERIUM_CHESTPLATE = new ArmorItem(CustomArmorMaterials.ETHERIUM_ARMOR, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ETHERIUM_LEGGINGS = new ArmorItem(CustomArmorMaterials.ETHERIUM_ARMOR, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ETHERIUM_BOOTS = new ArmorItem(CustomArmorMaterials.ETHERIUM_ARMOR, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ETHERIUM_SWORD = new EtheriumSwordItem(new EtheriumToolMaterial());
	public static final Item ETHERIUM_PICKAXE = new EtheriumPickaxeItem(new EtheriumToolMaterial());
	public static final Item ETHERIUM_AXE = new EtheriumAxeItem(new EtheriumToolMaterial());
	public static final Item ETHERIUM_SHOVEL = new EtheriumShovelItem(new EtheriumToolMaterial());
	public static final Item ETHERIUM_HOE = new EtheriumHoeItem(new EtheriumToolMaterial());

	public static final Item OBSIDIAN_SWORD = new ObsidianSwordItem(new ObsidianToolMaterial());
	public static final Item OBSIDIAN_PICKAXE = new ObsidianPickaxeItem(new ObsidianToolMaterial());
	public static final Item OBSIDIAN_AXE = new ObsidianAxeItem(new ObsidianToolMaterial());
	public static final Item OBSIDIAN_SHOVEL = new ObsidianShovelItem(new ObsidianToolMaterial());
	public static final Item OBSIDIAN_HOE = new ObsidianHoeItem(new ObsidianToolMaterial());

	public static final Item GIANT_SWORD = new GiantSwordItem(new GiantToolMaterial());

	public static final Item GEMSTONE_BLOCK_ITEM = new BlockItem(GEMSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GEMSTONE_SHARD = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item GEMSTONE_APPLE = new Item(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(3).saturationModifier(9.6f).alwaysEdible()
					.statusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 1)), 1f)
					.statusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 30, 0)), 1f)
					.statusEffect((new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 30, 0)), 1f)
					.build()));
	public static final Item GEMFUEL = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Item PRIMORDIAL_CATALYST = new PrimordialCatalyst();
	public static final Item TOM_YUM_STEW = new TomYumStew();
	public static final Item GOLDEN_HEAD = new GoldenHead();

	public static final Item SWORD_OF_THE_NIGHT = new SwordOfTheNight(new SwordOfTheNightToolMaterial());

	public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item BRONZE_ORE_ITEM = new BlockItem(BRONZE_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BRONZE_BLOCK_ITEM = new BlockItem(BRONZE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BRONZE_HELMET = new ArmorItem(CustomArmorMaterials.BRONZE_ARMOR, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BRONZE_CHESTPLATE = new ArmorItem(CustomArmorMaterials.BRONZE_ARMOR, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BRONZE_LEGGINGS = new ArmorItem(CustomArmorMaterials.BRONZE_ARMOR, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BRONZE_BOOTS = new ArmorItem(CustomArmorMaterials.BRONZE_ARMOR, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BRONZE_SWORD = new BronzeSwordItem(new BronzeToolMaterial());
	public static final Item BRONZE_PICKAXE = new BronzePickaxeItem(new BronzeToolMaterial());
	public static final Item BRONZE_AXE = new BronzeAxeItem(new BronzeToolAlternateMaterial());
	public static final Item BRONZE_SHOVEL = new BronzeShovelItem(new BronzeToolMaterial());
	public static final Item BRONZE_HOE = new BronzeHoeItem(new BronzeToolAlternateMaterial());

	public static final Item METAL_ALLOY = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.UNCOMMON));
	public static final Item ALLOY_HELMET = new ArmorItem(CustomArmorMaterials.ALLOY_ARMOR, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ALLOY_CHESTPLATE = new ArmorItem(CustomArmorMaterials.ALLOY_ARMOR, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ALLOY_LEGGINGS = new ArmorItem(CustomArmorMaterials.ALLOY_ARMOR, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ALLOY_BOOTS = new ArmorItem(CustomArmorMaterials.ALLOY_ARMOR, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item ALLOY_SWORD = new AlloySwordItem(new AlloySwordMaterial());
	public static final Item ALLOY_PICKAXE = new AlloyPickaxeItem(new AlloyToolAlternateMaterial());
	public static final Item ALLOY_AXE = new AlloyAxeItem(new AlloyToolMaterial());
	public static final Item ALLOY_SHOVEL = new AlloyShovelItem(new AlloyToolMaterial());
	public static final Item ALLOY_HOE = new AlloyHoeItem(new AlloyToolMaterial());

	public static final Item SOAKED_HANDS_MUSIC_DISC = new SoakedHandsMusicDisc(0, soakedHandsSoundEvent);

	public static final Item OTHERSTONE_BLOCK_ITEM = new BlockItem(OTHERSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item EARTHSTONE_BLOCK_ITEM = new BlockItem(EARTHSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item COBALT_ORE_ITEM = new BlockItem(COBALT_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item FORTISTEEL_EARTHSTONE_ITEM = new BlockItem(FORTISTEEL_EARTHSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FORTISTEEL_OTHERSTONE_ITEM = new BlockItem(FORTISTEEL_OTHERSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item PURIGOLD_EARTHSTONE_ITEM = new BlockItem(PURIGOLD_EARTHSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PURIGOLD_OTHERSTONE_ITEM = new BlockItem(PURIGOLD_OTHERSTONE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item SMART_PEARL = new SmartPearlItem();
	public static final Item FIREBALL = new FireballItem();
	public static final Item GAY_FIREBALL = new GayFireballItem();

//	public static final Item GOLDEN_HEAD = new WallStandingBlockItem(GOLDEN_HEAD_BLOCK, GOLDEN_HEAD_WALL_BLOCK, (new Item.Settings()).group(ItemGroup.DECORATIONS).rarity(Rarity.UNCOMMON));

	// Enchantment Definitions
	public static Enchantment harvesterEnchantment = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(EnhancedCraft.MOD_ID, "harvester"),
			new HarvesterEnchantment()
	);

	// Ore Generation Definitions
	public static ConfiguredFeature<?, ?> etheriumOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.ETHERIUM_ORE_BLOCK.getDefaultState(),
					5)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					9))) // max y level
			.spreadHorizontally();

	public static ConfiguredFeature<?, ?> bronzeOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.BRONZE_ORE_BLOCK.getDefaultState(),
					12)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					80))) // max y level
			.spreadHorizontally()
			.rangeOf(128) // Circular spread
			.repeat(20); // number of veins per chunk

	public static ConfiguredFeature<?, ?> gemstoneFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.GEMSTONE_BLOCK.getDefaultState(),
					8)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					6, // min y level
					20))) // max y level
			.spreadHorizontally()
			.rangeOf(32) // Circular spread
			.repeat(4); // number of veins per chunk

	// Status Effect Definitions
	public static final StatusEffect DETERIORATION_STATUS_EFFECT = new DeteriorationStatusEffect();

	// Entity Definitions
	public static final EntityType<HeroBrineEntity> HEROBRINE_ENTITY_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier(EnhancedCraft.MOD_ID, "herobrine"), FabricEntityTypeBuilder.<HeroBrineEntity>create(SpawnGroup.CREATURE, HeroBrineEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build());
	public static final EntityType<SmartPearlEntity> SMART_PEARL_ENTITY_TYPE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(EnhancedCraft.MOD_ID, "smart_pearl"),
			FabricEntityTypeBuilder.<SmartPearlEntity>create(SpawnGroup.MISC, SmartPearlEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build()
	);

//	public static final BlockEntityType<SkullBlockEntity> CUSTOM_SKULLS =  BlockEntityType.Builder.create(SkullBlockEntity::new, GOLDEN_HEAD_BLOCK, GOLDEN_HEAD_WALL_BLOCK).build(null);

	// Tags Definitions
	public static final Tag<Item> OVERWORLD_ARMOR = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/overworld_armor"));
	public static final Tag<Item> OVERWORLD_TOOLS = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "tools/overworld_tools"));
	public static final Tag<Item> ETHERIUM_ARMOR = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/etherium_armor"));

	// World Definitions
	public static final RegistryKey<World> MIRRORED_DIMENSION = RegistryKey.of(Registry.DIMENSION, new Identifier(EnhancedCraft.MOD_ID, "mirrored_dimension"));

	// Item Registration Method
	public static void Registry() {
		// Item Registry
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium"), ETHERIUM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), ETHERIUM_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_block"), ETHERIUM_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_helmet"), ETHERIUM_HELMET);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_chestplate"), ETHERIUM_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_leggings"), ETHERIUM_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_boots"), ETHERIUM_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_sword"), ETHERIUM_SWORD);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_pickaxe"), ETHERIUM_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_axe"), ETHERIUM_AXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_shovel"), ETHERIUM_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_hoe"), ETHERIUM_HOE);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_sword"), OBSIDIAN_SWORD);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_pickaxe"), OBSIDIAN_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_axe"), OBSIDIAN_AXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_shovel"), OBSIDIAN_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "obsidian_hoe"), OBSIDIAN_HOE);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "giant_sword"), GIANT_SWORD);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone"), GEMSTONE_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone_shard"), GEMSTONE_SHARD);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemfuel"), GEMFUEL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone_apple"), GEMSTONE_APPLE);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "primordial_catalyst"), PRIMORDIAL_CATALYST);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "tom_yum_stew"), TOM_YUM_STEW);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "golden_head"), GOLDEN_HEAD);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "sword_of_the_night"), SWORD_OF_THE_NIGHT);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_ingot"), BRONZE_INGOT);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_ore"), BRONZE_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_block"), BRONZE_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_helmet"), BRONZE_HELMET);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_chestplate"), BRONZE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_leggings"), BRONZE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_boots"), BRONZE_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_sword"), BRONZE_SWORD);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_pickaxe"), BRONZE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_axe"), BRONZE_AXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_shovel"), BRONZE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_hoe"), BRONZE_HOE);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "metal_alloy"), METAL_ALLOY);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_helmet"), ALLOY_HELMET);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_chestplate"), ALLOY_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_leggings"), ALLOY_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_boots"), ALLOY_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_sword"), ALLOY_SWORD);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_pickaxe"), ALLOY_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_axe"), ALLOY_AXE);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_shovel"), ALLOY_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_hoe"), ALLOY_HOE);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "music_disc_soaked_hands"), SOAKED_HANDS_MUSIC_DISC);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "otherstone"), OTHERSTONE_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "earthstone"), EARTHSTONE_BLOCK_ITEM);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "cobalt_ore"), COBALT_ORE_ITEM);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_earthstone"), FORTISTEEL_EARTHSTONE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_otherstone"), FORTISTEEL_OTHERSTONE_ITEM);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_earthstone"), PURIGOLD_EARTHSTONE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_otherstone"), PURIGOLD_OTHERSTONE_ITEM);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "smart_pearl"), SMART_PEARL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fireball"), FIREBALL);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "catastrophically_gay_fireball"), GAY_FIREBALL);

		// Fuel Registry
		FuelRegistry.INSTANCE.add(GEMFUEL, 1200 * 5);

		// Block Registry
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "otherstone"), OTHERSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "earthstone"), EARTHSTONE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), ETHERIUM_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_ore"), BRONZE_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "cobalt_ore"), COBALT_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_earthstone"), FORTISTEEL_EARTHSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_otherstone"), FORTISTEEL_OTHERSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_earthstone"), PURIGOLD_EARTHSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_otherstone"), PURIGOLD_OTHERSTONE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_block"), ETHERIUM_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_block"), BRONZE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "golden_head"), GOLDEN_HEAD_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "golden_head_wall"), GOLDEN_HEAD_WALL_BLOCK);

		// SoundEvents Registry
		Registry.register(Registry.SOUND_EVENT, ECRegistry.SOAKED_HANDS, soakedHandsSoundEvent);

		Registry.register(Registry.SOUND_EVENT, ECRegistry.ETHERIUM_ENRAGED_SOUND, etheriumEnragedSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.ETHERIUM_ENRAGED_KILL, etheriumEnragedKillSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.ETHERIUM_ENRAGED_ENDED_SOUND, etheriumEnragedEndedSoundEvent);

		Registry.register(Registry.SOUND_EVENT, ECRegistry.SMART_PEARL_THROW, smartPearlThrowSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.SMART_PEARL_TELEPORT, smartPearlTeleportSoundEvent);

		// Structure Generation Registry
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_etherium_overworld"), etheriumOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_bronze_overworld"), bronzeOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_gemstone_overworld"), gemstoneFeature);

		// Status Effect Registry
		Registry.register(Registry.STATUS_EFFECT, new Identifier(EnhancedCraft.MOD_ID, "deterioration"), DETERIORATION_STATUS_EFFECT);

		// Entity Registry
		FabricDefaultAttributeRegistry.register(HEROBRINE_ENTITY_ENTITY_TYPE, HeroBrineEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D));

//		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EnhancedCraft.MOD_ID, "custom_skulls"), CUSTOM_SKULLS);
	}
}