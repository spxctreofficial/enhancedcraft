package com.spxctreofficial.enhancedcraft.registry.portal;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ECPortalRegistry {

	public static final Identifier MIRRORED_DIMENSION = new Identifier(EnhancedCraft.MOD_ID, "mirrored_dimension");

	// Portal Registry
	public static void registerPortals() {
		CustomPortalApiRegistry.addPortal(ECRegistry.GEMSTONE_BLOCK, Blocks.FIRE, ECRegistry.CUSTOM_PORTAL_BLOCK, MIRRORED_DIMENSION, DyeColor.PINK.getMaterialColor().color);
	}
}
