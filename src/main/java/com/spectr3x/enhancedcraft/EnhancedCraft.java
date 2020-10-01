package com.spectr3x.enhancedcraft;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancedCraft implements ModInitializer {
	public static final String MOD_ID = "enhancedcraft";
	public static final Logger logger = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize () {
		ModRegistry.registry();
	}
}
