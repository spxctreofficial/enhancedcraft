package com.spxctreofficial.enhancedcraft.registry.portals;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ECPortalRegistry {

	public static final Identifier MIRRORED_DIMENSION = new Identifier(EnhancedCraft.MOD_ID, "mirrored_dimension");
	public static final Identifier OTHERWORLD = new Identifier(EnhancedCraft.MOD_ID, "otherworld");

	// Portal Registry
	public static void register() {
		CustomPortalApiRegistry.addPortal(ECRegistry.GEMSTONE_BLOCK, Blocks.FIRE, ECRegistry.CUSTOM_PORTAL_BLOCK, MIRRORED_DIMENSION, DyeColor.PINK.getMaterialColor().color);
		CustomPortalApiRegistry.addPortal(Blocks.POLISHED_ANDESITE, Blocks.FIRE, OTHERWORLD, DyeColor.BROWN.getMaterialColor().color);
	}
}
