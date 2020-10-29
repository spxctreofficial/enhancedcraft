package com.spectr3x.enhancedcraft;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.api.ModifierKeyCode;
import me.shedaniel.clothconfig2.gui.entries.DropdownBoxEntry;
import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.clothconfig2.impl.ConfigEntryBuilderImpl;
import me.shedaniel.clothconfig2.impl.builders.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.stream.Collectors;

@Config(name = EnhancedCraft.MOD_ID)
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.CollapsibleObject
	DisplayBackground displayBackground = new DisplayBackground();
	public boolean enableSkyBox = true;

	public static class DisplayBackground {
		/*
		 * public static boolean doDefaultBackground = true; public static boolean
		 * doClassicBackground = false; public static boolean doDiamondBackground =
		 * false; public static boolean doStoneBrickBackground = false; public static
		 * boolean doGemstoneBackground = false;
		*/
		@Comment("Declares the option menu background screen.")
		@ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
		public static String customBackgrounds = CustomBackgrounds.doDefaultBackground.getKey();

		@Environment(EnvType.CLIENT)
		public enum CustomBackgrounds implements SelectionListEntry.Translatable {
			doDefaultBackground {
					@Override
					public String getKey() {
						return "text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doDefaultBackground";
					}
			},
			doClassicBackground {
					@Override
					public String getKey() {
					return "text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doClassicBackground";
				}
			},
			doDiamondBackground {
					@Override
					public String getKey() {
					return "text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doDiamondBackground";
				}
			},
			doStoneBrickBackground {
					@Override
					public String getKey() {
					return "text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doStoneBrickBackground";
				}
			},
			doGemstoneBackground {
					@Override
					public String getKey() {
					return "text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doGemstoneBackground";
					}
			}
		}
	}
}
