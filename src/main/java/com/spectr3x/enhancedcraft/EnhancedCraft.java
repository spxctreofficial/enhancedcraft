package com.spectr3x.enhancedcraft;

import com.spectr3x.enhancedcraft.registry.ModRegistry;

import net.fabricmc.api.ModInitializer;

public class EnhancedCraft implements ModInitializer{

    public static final String MOD_ID = "enhancedcraft";

	@Override
	public void onInitialize() {
		ModRegistry.Registry();
	}

}