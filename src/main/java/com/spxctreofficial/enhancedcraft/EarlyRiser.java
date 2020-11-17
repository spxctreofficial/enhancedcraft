package com.spxctreofficial.enhancedcraft;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.Items;

import static com.spxctreofficial.enhancedcraft.EnhancedCraft.LOGGER;

public class EarlyRiser implements Runnable {

	@Override
	public void run() {
		EnchantmentTarget();
	}

	private void EnchantmentTarget() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
		ClassTinkerers.enumBuilder(enchantmentTarget, new Class[0]).addEnumSubclass("HOE", "com.spxctreofficial.enhancedcraft.registry.enchantments.HoeEnchantmentTarget").build();
	}
}
