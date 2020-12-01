package com.spxctreofficial.enhancedcraft.registry.tags;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class ECTagRegistry {
	// Tags Definitions
	public static final Tag<Item> OVERWORLD_ARMOR = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/overworld_armor"));
	public static final Tag<Item> ETHERIUM_ARMOR = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/etherium_armor"));
	public static final Tag<Item> AECORON_ARMOR = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "armor/aecoron_armor"));

	public static final Tag<Item> OVERWORLD_TOOLS = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "tools/overworld_tools"));
	public static final Tag<Item> EXTENDS_FIRE_DURATION = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "tools/extends_fire_duration"));
	public static final Tag<Item> IS_WATER_FATIGUE_IMMUNE = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "tools/is_water_fatigue_immune"));

	public static final Tag<Item> TRIDENT_MOLDS = TagRegistry.item(new Identifier(EnhancedCraft.MOD_ID, "misc/trident_molds"));

	// World Definitions
	public static final RegistryKey<World> MIRRORED_DIMENSION = RegistryKey.of(Registry.DIMENSION, new Identifier(EnhancedCraft.MOD_ID, "mirrored_dimension"));
	public static final RegistryKey<World> OTHERWORLD = RegistryKey.of(Registry.DIMENSION, new Identifier(EnhancedCraft.MOD_ID, "otherworld"));
}
