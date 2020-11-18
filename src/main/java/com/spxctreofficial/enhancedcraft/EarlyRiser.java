package com.spxctreofficial.enhancedcraft;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EarlyRiser implements Runnable {

	@Override
	public void run() {
		enchantmentTarget();
	}

	private void enchantmentTarget() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
		ClassTinkerers.enumBuilder(enchantmentTarget, new Class[0]).addEnumSubclass("HOE", "com.spxctreofficial.enhancedcraft.registry.enchantments.HoeEnchantmentTarget").build();
	}
}
