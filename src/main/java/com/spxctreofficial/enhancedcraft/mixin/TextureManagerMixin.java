package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

/*
	This code was borrowed and modified from https://github.com/joaoh1/BoringBackgrounds.
*/
@Mixin(TextureManager.class)
public class TextureManagerMixin {
	@Shadow
	public void registerTexture (Identifier id, AbstractTexture abstractTexture) {}
//	private static final Identifier vanillaTweaksInventory = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/inventory.png");
//	private static final Identifier vanillaTweaksTabInv = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_inventory.png");
//	private static final Identifier vanillaTweaksTabSearch = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_item_search.png");
//	private static final Identifier vanillaTweaksTabItems = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_items.png");
//	private static final Identifier vanillaTweaksCraftingTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/crafting_table.png");
//	private static final Identifier vanillaTweaksStonecutter = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/stonecutter.png");
//	private static final Identifier vanillaTweaksFurnace = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/furnace.png");
//	private static final Identifier vanillaTweaksBlastFurnace = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/blast_furnace.png");
//	private static final Identifier vanillaTweaksSmoker = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/smoker.png");
//	private static final Identifier vanillaTweaksBrewingStand = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/brewing_stand.png");
//	private static final Identifier vanillaTweaksDoubleChest = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/generic_54.png");
//	private static final Identifier vanillaTweaksShulkerBox = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/shulker_box.png");
//	private static final Identifier vanillaTweaksDispenser = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/dispenser.png");
//	private static final Identifier vanillaTweaksHopper = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/hopper.png");
//	private static final Identifier vanillaTweaksEnchanting = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/enchanting_table.png");
//	private static final Identifier vanillaTweaksAnvil = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/anvil.png");
//	private static final Identifier vanillaTweaksSmithingTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/smithing_table");
//	private static final Identifier vanillaTweaksGrindstone = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/grindstone.png");
//	private static final Identifier vanillaTweaksCartographyTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/cartography_table.png");
//	private static final Identifier vanillaTweaksLoom = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/loom.png");
//	private static final Identifier vanillaTweaksBeacon = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/beacon.png");
//	private static final Identifier vanillaTweaksHorse = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/horse.png");
//	private static final Identifier vanillaTweaksVillager = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/villager.png");
//	private static final Identifier vanillaTweaksVillager2 = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/villager2.png");
//	private static final Identifier vanillaTweaksTabs = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tabs.png");
//	private static final Identifier vanillaTweaksStatsIcons = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/stats_icons.png");
//
//	private static final Identifier classicInventory = new Identifier("minecraft:textures/gui/containers/inventory.png");
//	private static final Identifier classicTabInv = new Identifier("minecraft:textures/gui/containers/tab_inventory.png");
//	private static final Identifier classicTabSearch = new Identifier("minecraft:textures/gui/containers/tab_item_search.png");
//	private static final Identifier classicTabItems = new Identifier("minecraft:textures/gui/containers/tab_items.png");
//	private static final Identifier classicCraftingTable = new Identifier("minecraft:textures/gui/containers/crafting_table.png");
//	private static final Identifier classicStonecutter = new Identifier("minecraft:textures/gui/containers/stonecutter.png");
//	private static final Identifier classicFurnace = new Identifier("minecraft:textures/gui/containers/furnace.png");
//	private static final Identifier classicBlastFurnace = new Identifier("minecraft:textures/gui/containers/blast_furnace.png");
//	private static final Identifier classicSmoker = new Identifier("minecraft:textures/gui/containers/smoker.png");
//	private static final Identifier classicBrewingStand = new Identifier("minecraft:textures/gui/containers/brewing_stand.png");
//	private static final Identifier classicDoubleChest = new Identifier("minecraft:textures/gui/containers/generic_54.png");
//	private static final Identifier classicShulkerBox = new Identifier("minecraft:textures/gui/containers/shulker_box.png");
//	private static final Identifier classicDispenser = new Identifier("minecraft:textures/gui/containers/dispenser.png");
//	private static final Identifier classicHopper = new Identifier("minecraft:textures/gui/containers/hopper.png");
//	private static final Identifier classicEnchanting = new Identifier("minecraft:textures/gui/containers/enchanting_table.png");
//	private static final Identifier classicAnvil = new Identifier("minecraft:textures/gui/containers/anvil.png");
//	private static final Identifier classicSmithingTable = new Identifier("minecraft:textures/gui/containers/smithing_table");
//	private static final Identifier classicGrindstone = new Identifier("minecraft:textures/gui/containers/grindstone.png");
//	private static final Identifier classicCartographyTable = new Identifier("minecraft:textures/gui/containers/cartography_table.png");
//	private static final Identifier classicLoom = new Identifier("minecraft:textures/gui/containers/loom.png");
//	private static final Identifier classicBeacon = new Identifier("minecraft:textures/gui/containers/beacon.png");
//	private static final Identifier classicHorse = new Identifier("minecraft:textures/gui/containers/horse.png");
//	private static final Identifier classicVillager = new Identifier("minecraft:textures/gui/containers/villager.png");
//	private static final Identifier classicVillager2 = new Identifier("minecraft:textures/gui/containers/villager2.png");
//	private static final Identifier classicTabs = new Identifier("minecraft:textures/gui/containers/tabs.png");
//	private static final Identifier classicStatsIcons = new Identifier("minecraft:textures/gui/containers/stats_icons.png");

	private static final Identifier DEFAULT_TEXTURE_OPTIONS = new Identifier("enhancedcraft:textures/gui/options_background_default.png");
	private static final Identifier CLASSIC_TEXTURE_OPTIONS = new Identifier("minecraft:textures/gui/options_background.png");
	private static final Identifier DIAMOND_BLOCK_TEXTURE_OPTIONS = new Identifier("enhancedcraft:textures/gui/options_background_diamondblock.png");
	private static final Identifier STONE_BRICK_TEXTURE_OPTIONS = new Identifier("enhancedcraft:textures/gui/options_background_stonebrick.png");
	private static final Identifier GEMSTONE_TEXTURE_OPTIONS = new Identifier("enhancedcraft:textures/gui/options_background_gemstone.png");

	private static final Identifier NEBULA_ICONS = new Identifier("enhancedcraft:textures/gui/icons_nebula.png");
	private static final Identifier VANILLA_TWEAKS_ICONS = new Identifier("enhancedcraft:textures/gui/icons_vanillatweaks.png");
	private static final Identifier OG_ICONS = new Identifier("enhancedcraft:textures/gui/icons_og.png");
	private static final Identifier CLASSIC_ICONS = new Identifier("minecraft:textures/gui/icons.png");

	private static final Identifier NEBULA_WIDGETS = new Identifier("enhancedcraft:textures/gui/widgets_nebula.png");
	private static final Identifier VANILLA_TWEAKS_WIDGETS = new Identifier("enhancedcraft:textures/gui/widgets_vanillatweaks.png");
	private static final Identifier THE_LEGEND_27_WIDGETS = new Identifier("enhancedcraft:textures/gui/widgets_legend27.png");
	private static final Identifier CLASSIC_WIDGETS = new Identifier("minecraft:textures/gui/widgets.png");

	private static final Identifier GRADIENT_GLINT = new Identifier("enhancedcraft:textures/misc/enchanted_item_glint_gradient.png");
	private static final Identifier OLD_GLINT = new Identifier("enhancedcraft:textures/misc/enchanted_item_glint_old.png");
	private static final Identifier CLASSIC_GLINT = new Identifier("minecraft:textures/misc/enchanted_item_glint.png");


	@Inject(
			at = @At(value = "INVOKE", target = "net/minecraft/client/texture/AbstractTexture.bindTexture()V"),
			method = "bindTextureInner(Lnet/minecraft/util/Identifier;)V",
			locals = LocalCapture.CAPTURE_FAILHARD,
			cancellable = true
	)
	private void redirectTexture(Identifier id, CallbackInfo info) {
		// ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		/*if (id == DrawableHelper.BACKGROUND_TEXTURE && config.displayBackground) {
			abstractTexture = new ResourceTexture(backgroundTexture);
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();

			This doesn't work lol suck it Zero
		}*/
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

//		ContainerController(config, id, info);
		optionsBackgroundController(config, id, info);
		iconsController(config, id, info);
		widgetsController(config, id, info);
		enchantmentGlintsController(config, id, info);
	}

	// Private methods to clean-up the code

//	private void ContainerController(ModConfig config, Identifier id, CallbackInfo info) {
//		switch (config.customContainers) {
//			case doVanillaTweaksContainers:
//				// Inventory Container
//				if (id == HandledScreen.BACKGROUND_TEXTURE) {
//					AbstractTexture abstractTexture = new ResourceTexture(vanillaTweaksInventory);
//					this.registerTexture(id, abstractTexture);
//					abstractTexture.bindTexture();
//					info.cancel();
//				}
//				if (id == HandledScreen.BACKGROUND_TEXTURE) {
//					AbstractTexture abstractTexture = new ResourceTexture(vanillaTweaksInventory);
//					this.registerTexture(id, abstractTexture);
//					abstractTexture.bindTexture();
//					info.cancel();
//				}
//		}
//	}
	private void optionsBackgroundController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == DrawableHelper.OPTIONS_BACKGROUND_TEXTURE) {
			AbstractTexture abstractTexture;
			switch (config.backgrounds) {
				case DO_CLASSIC_BACKGROUND:
					abstractTexture = new ResourceTexture(CLASSIC_TEXTURE_OPTIONS);
					break;
				case DO_DIAMOND_BACKGROUND:
					abstractTexture = new ResourceTexture(DIAMOND_BLOCK_TEXTURE_OPTIONS);
					break;
				case DO_STONE_BRICK_BACKGROUND:
					abstractTexture = new ResourceTexture(STONE_BRICK_TEXTURE_OPTIONS);
					break;
				case DO_GEMSTONE_BACKGROUND:
					abstractTexture = new ResourceTexture(GEMSTONE_TEXTURE_OPTIONS);
					break;
				default:
					abstractTexture = new ResourceTexture(DEFAULT_TEXTURE_OPTIONS);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void iconsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == DrawableHelper.GUI_ICONS_TEXTURE) {
			AbstractTexture abstractTexture;
			switch (config.icons) {
				case DO_VANILLA_TWEAKS_ICONS:
					abstractTexture = new ResourceTexture(VANILLA_TWEAKS_ICONS);
					break;
				case DO_OG_ICONS:
					abstractTexture = new ResourceTexture(OG_ICONS);
					break;
				case DO_CLASSIC_ICONS:
					abstractTexture = new ResourceTexture(CLASSIC_ICONS);
					break;
				default:
					abstractTexture = new ResourceTexture(NEBULA_ICONS);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void widgetsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == AbstractButtonWidget.WIDGETS_LOCATION) {
			AbstractTexture abstractTexture;
			switch (config.widgets) {
				case DO_VANILLA_TWEAKS_WIDGETS:
					abstractTexture = new ResourceTexture(VANILLA_TWEAKS_WIDGETS);
					break;
				case DO_THE_LEGEND_27_WIDGETS:
					abstractTexture = new ResourceTexture(THE_LEGEND_27_WIDGETS);
					break;
				case DO_CLASSIC_WIDGETS:
					abstractTexture = new ResourceTexture(CLASSIC_WIDGETS);
					break;
				default:
					abstractTexture = new ResourceTexture(NEBULA_WIDGETS);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void enchantmentGlintsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == ItemRenderer.ENCHANTED_ITEM_GLINT) {
			AbstractTexture abstractTexture;
			switch (config.enchantmentGlints) {
				case DO_OLD_GLINT:
					abstractTexture = new ResourceTexture(OLD_GLINT);
					break;
				case DO_CLASSIC_GLINT:
					abstractTexture = new ResourceTexture(CLASSIC_GLINT);
					break;
				default:
					abstractTexture = new ResourceTexture(GRADIENT_GLINT);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
}