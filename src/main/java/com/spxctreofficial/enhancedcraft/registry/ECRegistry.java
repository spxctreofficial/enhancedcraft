package com.spxctreofficial.enhancedcraft.registry;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.entity.HeroBrineEntity;
import com.spxctreofficial.enhancedcraft.entity.SmartPearlEntity;
import com.spxctreofficial.enhancedcraft.registry.misc.FireballItem;
import com.spxctreofficial.enhancedcraft.registry.status_effects.DeteriorationStatusEffect;
import com.spxctreofficial.enhancedcraft.registry.tools.*;

import com.spxctreofficial.enhancedcraft.registry.armor.CustomArmorMaterials;
import com.spxctreofficial.enhancedcraft.registry.blocks.*;
import com.spxctreofficial.enhancedcraft.registry.foodstuffs.*;
import com.spxctreofficial.enhancedcraft.registry.misc.*;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
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
	public static final Identifier SoakedHands = new Identifier("enhancedcraft:soaked_hands");

	public static final Identifier EtheriumEnragedSound = new Identifier("enhancedcraft:etherium_enraged_sound");
	public static final Identifier EtheriumEnragedKill = new Identifier("enhancedcraft:etherium_enraged_kill");
	public static final Identifier EtheriumEnragedEndedSound = new Identifier("enhancedcraft:etherium_enraged_ended_sound");

	public static final Identifier SmartPearlThrow = new Identifier("enhancedcraft:smart_pearl_throw");
	public static final Identifier SmartPearlTeleport = new Identifier("enhancedcraft:smart_pearl_teleport");

	public static SoundEvent SoakedHandsSoundEvent = new SoundEvent(SoakedHands);

	public static SoundEvent EtheriumEnragedSoundEvent = new SoundEvent(EtheriumEnragedSound);
	public static SoundEvent EtheriumEnragedKillSoundEvent = new SoundEvent(EtheriumEnragedKill);
	public static SoundEvent EtheriumEnragedEndedSoundEvent = new SoundEvent(EtheriumEnragedEndedSound);

	public static SoundEvent SmartPearlThrowSoundEvent = new SoundEvent(SmartPearlThrow);
	public static SoundEvent SmartPearlTeleportSoundEvent = new SoundEvent(SmartPearlTeleport);

	// Block Definitions
	public static final Block OtherstoneBlock = new OtherstoneBlock();
	public static final Block EarthstoneBlock = new EarthstoneBlock();

	public static final Block EtheriumOreBlock = new EtheriumOreBlock();
	public static final Block BronzeOreBlock = new BronzeOreBlock();
	public static final Block GemstoneBlock = new GemstoneBlock();
	public static final Block CobaltOreBlock = new CobaltOreBlock();
	public static final Block FortisteelEarthstoneBlock = new FortisteelEarthstoneBlock();
	public static final Block FortisteelOtherstoneBlock = new FortisteelOtherstoneBlock();
	public static final Block PurigoldEarthstoneBlock = new PurigoldEarthstoneBlock();
	public static final Block PurigoldOtherstoneBlock = new PurigoldOtherstoneBlock();

	public static final Block EtheriumBlock = new EtheriumBlock();
	public static final Block BronzeBlock = new BronzeBlock();

	// Item Definitions
	public static final Item Etherium = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.EPIC));
	public static final Item EtheriumOreItem = new BlockItem(EtheriumOreBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item EtheriumBlockItem = new BlockItem(EtheriumBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item EtheriumHelmet = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item EtheriumChestplate = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item EtheriumLeggings = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item EtheriumBoots = new ArmorItem(CustomArmorMaterials.EtheriumArmor, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item EtheriumSwordItem = new EtheriumSwordItem(new EtheriumToolMaterial());
	public static final Item EtheriumPickaxeItem = new EtheriumPickaxeItem(new EtheriumToolMaterial());
	public static final Item EtheriumAxeItem = new EtheriumAxeItem(new EtheriumToolMaterial());
	public static final Item EtheriumShovelItem = new EtheriumShovelItem(new EtheriumToolMaterial());
	public static final Item EtheriumHoeItem = new EtheriumHoeItem(new EtheriumToolMaterial());

	public static final Item ObsidianSwordItem = new ObsidianSwordItem(new ObsidianToolMaterial());
	public static final Item ObsidianPickaxeItem = new ObsidianPickaxeItem(new ObsidianToolMaterial());
	public static final Item ObsidianAxeItem = new ObsidianAxeItem(new ObsidianToolMaterial());
	public static final Item ObsidianShovelItem = new ObsidianShovelItem(new ObsidianToolMaterial());
	public static final Item ObsidianHoeItem = new ObsidianHoeItem(new ObsidianToolMaterial());

	public static final Item GiantSwordItem = new GiantSwordItem(new GiantToolMaterial());

	public static final Item GemstoneBlockItem = new BlockItem(GemstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item GemstoneShard = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item GemstoneApple = new Item(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(3).saturationModifier(9.6f).alwaysEdible()
					.statusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 1)), 1f)
					.statusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 30, 0)), 1f)
					.statusEffect((new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 30, 0)), 1f)
					.build()));
	public static final Item Gemfuel = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Item PrimordialCatalyst = new PrimordialCatalyst();
	public static final Item TomYumStew = new TomYumStew();

	public static final Item SwordOfTheNight = new SwordOfTheNight(new SwordOfTheNightToolMaterial());

	public static final Item BronzeIngot = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item BronzeOreItem = new BlockItem(BronzeOreBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BronzeBlockItem = new BlockItem(BronzeBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item BronzeHelmet = new ArmorItem(CustomArmorMaterials.BronzeArmor, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BronzeChestplate = new ArmorItem(CustomArmorMaterials.BronzeArmor, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BronzeLeggings = new ArmorItem(CustomArmorMaterials.BronzeArmor, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BronzeBoots = new ArmorItem(CustomArmorMaterials.BronzeArmor, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item BronzeSwordItem = new BronzeSwordItem(new BronzeToolMaterial());
	public static final Item BronzePickaxeItem = new BronzePickaxeItem(new BronzeToolMaterial());
	public static final Item BronzeAxeItem = new BronzeAxeItem(new BronzeToolAlternateMaterial());
	public static final Item BronzeShovelItem = new BronzeShovelItem(new BronzeToolMaterial());
	public static final Item BronzeHoeItem = new BronzeHoeItem(new BronzeToolAlternateMaterial());

	public static final Item MetalAlloy = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.UNCOMMON));
	public static final Item AlloyHelmet = new ArmorItem(CustomArmorMaterials.AlloyArmor, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item AlloyChestplate = new ArmorItem(CustomArmorMaterials.AlloyArmor, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item AlloyLeggings = new ArmorItem(CustomArmorMaterials.AlloyArmor, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item AlloyBoots = new ArmorItem(CustomArmorMaterials.AlloyArmor, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
	public static final Item AlloySwordItem = new AlloySwordItem(new AlloySwordMaterial());
	public static final Item AlloyPickaxeItem = new AlloyPickaxeItem(new AlloyToolAlternateMaterial());
	public static final Item AlloyAxeItem = new AlloyAxeItem(new AlloyToolMaterial());
	public static final Item AlloyShovelItem = new AlloyShovelItem(new AlloyToolMaterial());
	public static final Item AlloyHoeItem = new AlloyHoeItem(new AlloyToolMaterial());

	public static final Item SoakedHandsMusicDisc = new SoakedHandsMusicDisc(0, SoakedHandsSoundEvent);

	public static final Item OtherstoneBlockItem = new BlockItem(OtherstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item EarthstoneBlockItem = new BlockItem(EarthstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item CobaltOreItem = new BlockItem(CobaltOreBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item FortisteelEarthstoneItem = new BlockItem(FortisteelEarthstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item FortisteelOtherstoneItem = new BlockItem(FortisteelOtherstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item PurigoldEarthstoneItem = new BlockItem(PurigoldEarthstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PurigoldOtherstoneItem = new BlockItem(PurigoldOtherstoneBlock, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item SmartPearlItem = new SmartPearlItem();
	public static final Item FireballItem = new FireballItem();
	public static final Item GayFireballItem = new GayFireballItem();

	// Ore Generation Definitions
	public static ConfiguredFeature<?, ?> EtheriumOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.EtheriumOreBlock.getDefaultState(),
					5)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					9))) // max y level
			.spreadHorizontally();

	public static ConfiguredFeature<?, ?> BronzeOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.BronzeOreBlock.getDefaultState(),
					12)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					80))) // max y level
			.spreadHorizontally()
			.method_30377(128) // Circular spread
			.repeat(20); // number of veins per chunk

	public static ConfiguredFeature<?, ?> GemstoneFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECRegistry.GemstoneBlock.getDefaultState(),
					8)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					6, // min y level
					20))) // max y level
			.spreadHorizontally()
			.method_30377(32) // Circular spread
			.repeat(4); // number of veins per chunk

	// Status Effect Definitions
	public static final StatusEffect DeteriorationStatusEffect = new DeteriorationStatusEffect();

	// Entity Definitions
	public static final EntityType<HeroBrineEntity> HerobrineEntity = Registry.register(Registry.ENTITY_TYPE, new Identifier(EnhancedCraft.MOD_ID, "herobrine"), FabricEntityTypeBuilder.<HeroBrineEntity>create(SpawnGroup.CREATURE, HeroBrineEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build());
	public static final EntityType<SmartPearlEntity> SmartPearlEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(EnhancedCraft.MOD_ID, "smart_pearl"),
			FabricEntityTypeBuilder.<SmartPearlEntity>create(SpawnGroup.MISC, SmartPearlEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build()
	);

	// Tags Definitions
	public static final Tag<Item> OverworldArmor = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/overworld_armor"));
	public static final Tag<Item> OverworldTools = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "tools/overworld_tools"));
	public static final Tag<Item> EtheriumArmor = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/etherium_armor"));

	// World Definitions
	public static final RegistryKey<World> MirroredDimension = RegistryKey.of(Registry.DIMENSION, new Identifier(EnhancedCraft.MOD_ID, "mirrored_dimension"));

	// Item Registration Method
	public static void Registry() {
		// Item Registry
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium"), Etherium);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "etherium_block"), EtheriumBlockItem);
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
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "gemstone_apple"), GemstoneApple);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "primordial_catalyst"), PrimordialCatalyst);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "tom_yum_stew"), TomYumStew);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "sword_of_the_night"), SwordOfTheNight);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_ingot"), BronzeIngot);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_ore"), BronzeOreItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_block"), BronzeBlockItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_helmet"), BronzeHelmet);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_chestplate"), BronzeChestplate);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_leggings"), BronzeLeggings);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_boots"), BronzeBoots);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_sword"), BronzeSwordItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_pickaxe"), BronzePickaxeItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_axe"), BronzeAxeItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_shovel"), BronzeShovelItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "bronze_hoe"), BronzeHoeItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "metal_alloy"), MetalAlloy);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_helmet"), AlloyHelmet);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_chestplate"), AlloyChestplate);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_leggings"), AlloyLeggings);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_boots"), AlloyBoots);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_sword"), AlloySwordItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_pickaxe"), AlloyPickaxeItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_axe"), AlloyAxeItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_shovel"), AlloyShovelItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "alloy_hoe"), AlloyHoeItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "music_disc_soaked_hands"), SoakedHandsMusicDisc);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "otherstone"), OtherstoneBlockItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "earthstone"), EarthstoneBlockItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "cobalt_ore"), CobaltOreItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_earthstone"), FortisteelEarthstoneItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_otherstone"), FortisteelOtherstoneItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_earthstone"), PurigoldEarthstoneItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_otherstone"), PurigoldOtherstoneItem);

		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "smart_pearl"), SmartPearlItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "fireball"), FireballItem);
		Registry.register(Registry.ITEM, new Identifier(EnhancedCraft.MOD_ID, "catastrophically_gay_fireball"), GayFireballItem);

		// Fuel Registry
		FuelRegistry.INSTANCE.add(Gemfuel, 1200 * 5);

		// Block Registry
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "otherstone"), OtherstoneBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "earthstone"), EarthstoneBlock);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), EtheriumOreBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_ore"), BronzeOreBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "cobalt_ore"), CobaltOreBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_earthstone"), FortisteelEarthstoneBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_otherstone"), FortisteelOtherstoneBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_earthstone"), PurigoldEarthstoneBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_otherstone"), PurigoldOtherstoneBlock);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_block"), EtheriumBlock);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_block"), BronzeBlock);

		// SoundEvents Registry
		Registry.register(Registry.SOUND_EVENT, ECRegistry.SoakedHands, SoakedHandsSoundEvent);

		Registry.register(Registry.SOUND_EVENT, ECRegistry.EtheriumEnragedSound, EtheriumEnragedSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.EtheriumEnragedKill, EtheriumEnragedKillSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.EtheriumEnragedEndedSound, EtheriumEnragedEndedSoundEvent);

		Registry.register(Registry.SOUND_EVENT, ECRegistry.SmartPearlThrow, SmartPearlThrowSoundEvent);
		Registry.register(Registry.SOUND_EVENT, ECRegistry.SmartPearlTeleport, SmartPearlTeleportSoundEvent);

		// Structure Generation Registry
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_etherium_overworld"), EtheriumOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_bronze_overworld"), BronzeOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancedCraft.MOD_ID, "ore_gemstone_overworld"), GemstoneFeature);

		// Status Effect Registry
		Registry.register(Registry.STATUS_EFFECT, new Identifier(EnhancedCraft.MOD_ID, "deterioration"), DeteriorationStatusEffect);

		// Entity Registry
		FabricDefaultAttributeRegistry.register(HerobrineEntity, HeroBrineEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D));
	}
}