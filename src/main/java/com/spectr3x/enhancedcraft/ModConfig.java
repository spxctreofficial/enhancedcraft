package com.spectr3x.enhancedcraft;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = EnhancedCraft.MOD_ID)
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.CollapsibleObject
	DisplayBackground displayBackground = new DisplayBackground();
	public boolean enableSkyBox = true;

	public static class DisplayBackground {
		public static boolean doCustomBackground = true;
		CustomBackgrounds customBackgrounds = CustomBackgrounds.Default;
		public static enum CustomBackgrounds {
			Default,
			Classic,
			Gemstone,
			Diamond,
			Stone_Bricks,
		}
	}
}
