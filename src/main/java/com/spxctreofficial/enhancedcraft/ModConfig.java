package com.spxctreofficial.enhancedcraft;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Config(name = EnhancedCraft.MOD_ID)
public class ModConfig implements ConfigData {

	@Comment("Declares the inventory and block container appearances.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public CustomContainers customContainers = CustomContainers.doVanillaTweaksContainers;
	@Comment("Declares the option menu background texture.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public CustomBackgrounds customBackgrounds = CustomBackgrounds.doDefaultBackground;
	@Comment("Declares the survival hotbar icons' appearance.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public CustomIcons customIcons = CustomIcons.doNebulaIcons;
	@Comment("Declares the button widgets and hotbar appearance.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public CustomWidgets customWidgets = CustomWidgets.doNebulaWidgets;

	@Environment(EnvType.CLIENT)
	public enum CustomContainers implements SelectionListEntry.Translatable {
		doVanillaTweaksContainers {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customContainers.doVanillaTweaksContainers";
			}
		},
		doClassicContainers {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customContainers.doClassicContainers";
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public enum CustomBackgrounds implements SelectionListEntry.Translatable {
		doDefaultBackground {
			@Override
			public String getKey() {
				String customBackgroundString = "text.autoconfig.enhancedcraft.option.customBackgrounds.doDefaultBackground";
				return customBackgroundString;
			}
		},
		doClassicBackground {
			@Override
			public String getKey() {
				String customBackgroundString = "text.autoconfig.enhancedcraft.option.customBackgrounds.doClassicBackground";
				return customBackgroundString;
			}
		},
		doDiamondBackground {
			@Override
			public String getKey() {
				String customBackgroundString = "text.autoconfig.enhancedcraft.option.customBackgrounds.doDiamondBackground";
				return customBackgroundString;
			}
		},
		doStoneBrickBackground {
			@Override
			public String getKey() {
				String customBackgroundString = "text.autoconfig.enhancedcraft.option.customBackgrounds.doStoneBrickBackground";
				return customBackgroundString;
			}
		},
		doGemstoneBackground {
			@Override
			public String getKey() {
				String customBackgroundString = "text.autoconfig.enhancedcraft.option.customBackgrounds.doGemstoneBackground";
				return customBackgroundString;
			}
		}
	}
	
	@Environment(EnvType.CLIENT)
	public enum CustomIcons implements SelectionListEntry.Translatable {
		doNebulaIcons {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customIcons.doNebulaIcons";
			}
		},
		doVanillaTweaksIcons {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customIcons.doVanillaTweaksIcons";
			}
		},
		doOGIcons {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customIcons.doOGIcons";
			}
		},
		doClassicIcons {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customIcons.doClassicIcons";
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public enum CustomWidgets implements SelectionListEntry.Translatable {
		doNebulaWidgets {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customWidgets.doNebulaWidgets";
			}
		},
		doVanillaTweaksWidgets {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customWidgets.doVanillaTweaksWidgets";
			}
		},
		doTheLegend27Widgets {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customWidgets.doTheLegend27Widgets";
			}
		},
		doClassicWidgets {
			@Override
			public String getKey() {
				return "text.autoconfig.enhancedcraft.option.customWidgets.doClassicWidgets";
			}
		}
	}
}
