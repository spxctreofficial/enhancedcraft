package com.spxctreofficial.enhancedcraft;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Environment(EnvType.CLIENT)
public class EnhancedCraftPotionHUD implements ModInitializer {

	public static final String MOD_ID = "enhancedcraft-potion-hud";
	public static final String MOD_NAME = "EnhancedCraft Potion HUD";
	public static Logger LOGGER = LogManager.getLogger();

	public HUD hud;

	public static void log(Level level, String message) {
		LOGGER.log(level, "[" + MOD_NAME + "] " + message);
	}

	@Override
	public void onInitialize() {
		log(Level.INFO, "Initializing");
		hud = new HUD();
	}

}
