package com.spxctreofficial.enhancedcraft.registry.features;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.registry.blocks.ECBlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ECFeatureRegistry {

	// Feature Definitions
	public static final ConfiguredFeature<?, ?> etheriumOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECBlockRegistry.ETHERIUM_ORE_BLOCK.getDefaultState(),
					5)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					9))) // max y level
			.spreadHorizontally();

	public static final ConfiguredFeature<?, ?> bronzeOreFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECBlockRegistry.BRONZE_ORE_BLOCK.getDefaultState(),
					12)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					0, // min y level
					80))) // max y level
			.spreadHorizontally()
			.rangeOf(128) // Circular spread
			.repeat(20); // number of veins per chunk

	public static final ConfiguredFeature<?, ?> gemstoneFeature = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ECBlockRegistry.GEMSTONE_BLOCK.getDefaultState(),
					8)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, // bottom offset
					6, // min y level
					20))) // max y level
			.spreadHorizontally()
			.rangeOf(32) // Circular spread
			.repeat(4); // number of veins per chunk

	public static void register() {
		// Ore Generation Registry
		RegistryKey<ConfiguredFeature<?, ?>> oreEtheriumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				new Identifier(EnhancedCraft.MOD_ID, "ore_etherium_overworld"));
		RegistryKey<ConfiguredFeature<?, ?>> oreBronzeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				new Identifier(EnhancedCraft.MOD_ID, "ore_bronze_overworld"));
		RegistryKey<ConfiguredFeature<?, ?>> oreGemstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				new Identifier(EnhancedCraft.MOD_ID, "ore_gemstone_overworld"));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreEtheriumOverworld.getValue(), etheriumOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreBronzeOverworld.getValue(), bronzeOreFeature);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreGemstoneOverworld.getValue(), gemstoneFeature);

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreEtheriumOverworld);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBronzeOverworld);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreGemstoneOverworld);
	}
}
