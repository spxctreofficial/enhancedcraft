package com.spxctreofficial.enhancedcraft.registry.enchantments;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ECEnchantmentRegistry {
	// Enchantment Definitions
	public static Enchantment harvesterEnchantment = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(EnhancedCraft.MOD_ID, "harvester"),
			new HarvesterEnchantment()
	);
	public static final Enchantment purifiedEnchantment = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(EnhancedCraft.MOD_ID, "purified"),
			new PurifiedEnchantment()
	);
}
