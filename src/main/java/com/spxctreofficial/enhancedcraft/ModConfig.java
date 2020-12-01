package com.spxctreofficial.enhancedcraft;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.NotNull;

@Config(name = EnhancedCraft.MOD_ID)
public class ModConfig implements ConfigData {

	@Comment("Declares the inventory and block container appearances. (currently WIP)")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public customContainers containers = customContainers.DO_VANILLA_TWEAKS_CONTAINERS;
	@Comment("Declares the option menu background texture.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public final customBackgrounds backgrounds = customBackgrounds.DO_DEFAULT_BACKGROUND;
	@Comment("Declares the survival hotbar icons' appearance.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public final customIcons icons = customIcons.DO_NEBULA_ICONS;
	@Comment("Declares the button widgets and hotbar appearance.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public final customWidgets widgets = customWidgets.DO_NEBULA_WIDGETS;
	@Comment("Declares the button widgets and hotbar appearance.")
	@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
	public final customEnchantmentGlints enchantmentGlints = customEnchantmentGlints.DO_GRADIENT_GLINT;

	@Environment(EnvType.CLIENT)
	public enum customContainers implements SelectionListEntry.Translatable {
		DO_VANILLA_TWEAKS_CONTAINERS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.containers.doVanillaTweaksContainers";
			}
		},
		DO_CLASSIC_CONTAINERS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.containers.doClassicContainers";
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public enum customBackgrounds implements SelectionListEntry.Translatable {
		DO_DEFAULT_BACKGROUND {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.backgrounds.doDefaultBackground";
			}
		},
		DO_CLASSIC_BACKGROUND {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.backgrounds.doClassicBackground";
			}
		},
		DO_DIAMOND_BACKGROUND {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.backgrounds.doDiamondBackground";
			}
		},
		DO_STONE_BRICK_BACKGROUND {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.backgrounds.doStoneBrickBackground";
			}
		},
		DO_GEMSTONE_BACKGROUND {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.backgrounds.doGemstoneBackground";
			}
		}
	}
	
	@Environment(EnvType.CLIENT)
	public enum customIcons implements SelectionListEntry.Translatable {
		DO_NEBULA_ICONS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.icons.doNebulaIcons";
			}
		},
		DO_VANILLA_TWEAKS_ICONS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.icons.doVanillaTweaksIcons";
			}
		},
		DO_OG_ICONS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.icons.doOGIcons";
			}
		},
		DO_CLASSIC_ICONS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.icons.doClassicIcons";
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public enum customWidgets implements SelectionListEntry.Translatable {
		DO_NEBULA_WIDGETS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.widgets.doNebulaWidgets";
			}
		},
		DO_VANILLA_TWEAKS_WIDGETS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.widgets.doVanillaTweaksWidgets";
			}
		},
		DO_THE_LEGEND_27_WIDGETS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.widgets.doTheLegend27Widgets";
			}
		},
		DO_CLASSIC_WIDGETS {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.widgets.doClassicWidgets";
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public enum customEnchantmentGlints implements SelectionListEntry.Translatable {
		DO_GRADIENT_GLINT {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.enchantmentGlints.doGradientGlint";
			}
		},
		DO_OLD_GLINT {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.enchantmentGlints.doOldGlint";
			}
		},
		DO_CLASSIC_GLINT {
			@Override
			public @NotNull String getKey() {
				return "text.autoconfig.enhancedcraft.option.enchantmentGlints.doClassicGlint";
			}
		}
	}
}
