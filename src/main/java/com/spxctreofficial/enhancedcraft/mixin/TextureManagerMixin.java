package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
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
	private static final Identifier vanillaTweaksInventory = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/inventory.png");
	private static final Identifier vanillaTweaksTabInv = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_inventory.png");
	private static final Identifier vanillaTweaksTabSearch = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_item_search.png");
	private static final Identifier vanillaTweaksTabItems = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tab_items.png");
	private static final Identifier vanillaTweaksCraftingTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/crafting_table.png");
	private static final Identifier vanillaTweaksStonecutter = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/stonecutter.png");
	private static final Identifier vanillaTweaksFurnace = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/furnace.png");
	private static final Identifier vanillaTweaksBlastFurnace = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/blast_furnace.png");
	private static final Identifier vanillaTweaksSmoker = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/smoker.png");
	private static final Identifier vanillaTweaksBrewingStand = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/brewing_stand.png");
	private static final Identifier vanillaTweaksDoubleChest = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/generic_54.png");
	private static final Identifier vanillaTweaksShulkerBox = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/shulker_box.png");
	private static final Identifier vanillaTweaksDispenser = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/dispenser.png");
	private static final Identifier vanillaTweaksHopper = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/hopper.png");
	private static final Identifier vanillaTweaksEnchanting = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/enchanting_table.png");
	private static final Identifier vanillaTweaksAnvil = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/anvil.png");
	private static final Identifier vanillaTweaksSmithingTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/smithing_table");
	private static final Identifier vanillaTweaksGrindstone = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/grindstone.png");
	private static final Identifier vanillaTweaksCartographyTable = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/cartography_table.png");
	private static final Identifier vanillaTweaksLoom = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/loom.png");
	private static final Identifier vanillaTweaksBeacon = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/beacon.png");
	private static final Identifier vanillaTweaksHorse = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/horse.png");
	private static final Identifier vanillaTweaksVillager = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/villager.png");
	private static final Identifier vanillaTweaksVillager2 = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/villager2.png");
	private static final Identifier vanillaTweaksTabs = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/tabs.png");
	private static final Identifier vanillaTweaksStatsIcons = new Identifier("enhancedcraft:textures/gui/containers/vanillatweaks/stats_icons.png");

	private static final Identifier classicInventory = new Identifier("minecraft:textures/gui/containers/inventory.png");
	private static final Identifier classicTabInv = new Identifier("minecraft:textures/gui/containers/tab_inventory.png");
	private static final Identifier classicTabSearch = new Identifier("minecraft:textures/gui/containers/tab_item_search.png");
	private static final Identifier classicTabItems = new Identifier("minecraft:textures/gui/containers/tab_items.png");
	private static final Identifier classicCraftingTable = new Identifier("minecraft:textures/gui/containers/crafting_table.png");
	private static final Identifier classicStonecutter = new Identifier("minecraft:textures/gui/containers/stonecutter.png");
	private static final Identifier classicFurnace = new Identifier("minecraft:textures/gui/containers/furnace.png");
	private static final Identifier classicBlastFurnace = new Identifier("minecraft:textures/gui/containers/blast_furnace.png");
	private static final Identifier classicSmoker = new Identifier("minecraft:textures/gui/containers/smoker.png");
	private static final Identifier classicBrewingStand = new Identifier("minecraft:textures/gui/containers/brewing_stand.png");
	private static final Identifier classicDoubleChest = new Identifier("minecraft:textures/gui/containers/generic_54.png");
	private static final Identifier classicShulkerBox = new Identifier("minecraft:textures/gui/containers/shulker_box.png");
	private static final Identifier classicDispenser = new Identifier("minecraft:textures/gui/containers/dispenser.png");
	private static final Identifier classicHopper = new Identifier("minecraft:textures/gui/containers/hopper.png");
	private static final Identifier classicEnchanting = new Identifier("minecraft:textures/gui/containers/enchanting_table.png");
	private static final Identifier classicAnvil = new Identifier("minecraft:textures/gui/containers/anvil.png");
	private static final Identifier classicSmithingTable = new Identifier("minecraft:textures/gui/containers/smithing_table");
	private static final Identifier classicGrindstone = new Identifier("minecraft:textures/gui/containers/grindstone.png");
	private static final Identifier classicCartographyTable = new Identifier("minecraft:textures/gui/containers/cartography_table.png");
	private static final Identifier classicLoom = new Identifier("minecraft:textures/gui/containers/loom.png");
	private static final Identifier classicBeacon = new Identifier("minecraft:textures/gui/containers/beacon.png");
	private static final Identifier classicHorse = new Identifier("minecraft:textures/gui/containers/horse.png");
	private static final Identifier classicVillager = new Identifier("minecraft:textures/gui/containers/villager.png");
	private static final Identifier classicVillager2 = new Identifier("minecraft:textures/gui/containers/villager2.png");
	private static final Identifier classicTabs = new Identifier("minecraft:textures/gui/containers/tabs.png");
	private static final Identifier classicStatsIcons = new Identifier("minecraft:textures/gui/containers/stats_icons.png");

	private static final Identifier defaultTexture_options = new Identifier("enhancedcraft:textures/gui/options_background_default.png");
	private static final Identifier classicTexture_options = new Identifier("minecraft:textures/gui/options_background.png");
	private static final Identifier diamondBlockTexture_options = new Identifier("enhancedcraft:textures/gui/options_background_diamondblock.png");
	private static final Identifier stoneBrickTexture_options = new Identifier("enhancedcraft:textures/gui/options_background_stonebrick.png");
	private static final Identifier gemstoneTexture_options = new Identifier("enhancedcraft:textures/gui/options_background_gemstone.png");

	private static final Identifier nebulaIcons = new Identifier("enhancedcraft:textures/gui/icons_nebula.png");
	private static final Identifier vanillaTweaksIcons = new Identifier("enhancedcraft:textures/gui/icons_vanillatweaks.png");
	private static final Identifier OGIcons = new Identifier("enhancedcraft:textures/gui/icons_og.png");
	private static final Identifier classicIcons = new Identifier("minecraft:textures/gui/icons.png");

	private static final Identifier nebulaWidgets = new Identifier("enhancedcraft:textures/gui/widgets_nebula.png");
	private static final Identifier vanillaTweaksWidgets = new Identifier("enhancedcraft:textures/gui/widgets_vanillatweaks.png");
	private static final Identifier theLegend27Widgets = new Identifier("enhancedcraft:textures/gui/widgets_legend27.png");
	private static final Identifier classicWidgets = new Identifier("minecraft:textures/gui/widgets.png");

	private static final Identifier gradientGlint = new Identifier("enhancedcraft:textures/misc/enchanted_item_glint_gradient.png");
	private static final Identifier oldGlint = new Identifier("enhancedcraft:textures/misc/enchanted_item_glint_old.png");
	private static final Identifier classicGlint = new Identifier("minecraft:textures/mic/enchanted_item_glint.png");


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

		ContainerController(config, id, info);
		OptionsBackgroundController(config, id, info);
		IconsController(config, id, info);
		WidgetsController(config, id, info);
		EnchantmentGlintsController(config, id, info);
	}

	// Private methods to clean-up the code

	private void ContainerController(ModConfig config, Identifier id, CallbackInfo info) {
		switch (config.customContainers) {
			case doVanillaTweaksContainers:
				// Inventory Container
				if (id == HandledScreen.BACKGROUND_TEXTURE) {
					AbstractTexture abstractTexture = new ResourceTexture(vanillaTweaksInventory);
					this.registerTexture(id, abstractTexture);
					abstractTexture.bindTexture();
					info.cancel();
				}
				if (id == HandledScreen.BACKGROUND_TEXTURE) {
					AbstractTexture abstractTexture = new ResourceTexture(vanillaTweaksInventory);
					this.registerTexture(id, abstractTexture);
					abstractTexture.bindTexture();
					info.cancel();
				}
		}
	}
	private void OptionsBackgroundController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == DrawableHelper.BACKGROUND_TEXTURE) {
			AbstractTexture abstractTexture;
			switch (config.customBackgrounds) {
				case doClassicBackground:
					abstractTexture = new ResourceTexture(classicTexture_options);
					break;
				case doDiamondBackground:
					abstractTexture = new ResourceTexture(diamondBlockTexture_options);
					break;
				case doStoneBrickBackground:
					abstractTexture = new ResourceTexture(stoneBrickTexture_options);
					break;
				case doGemstoneBackground:
					abstractTexture = new ResourceTexture(gemstoneTexture_options);
					break;
				default:
					abstractTexture = new ResourceTexture(defaultTexture_options);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void IconsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == DrawableHelper.GUI_ICONS_TEXTURE) {
			AbstractTexture abstractTexture;
			switch (config.customIcons) {
				case doVanillaTweaksIcons:
					abstractTexture = new ResourceTexture(vanillaTweaksIcons);
					break;
				case doOGIcons:
					abstractTexture = new ResourceTexture(OGIcons);
					break;
				case doClassicIcons:
					abstractTexture = new ResourceTexture(classicIcons);
					break;
				default:
					abstractTexture = new ResourceTexture(nebulaIcons);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void WidgetsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == AbstractButtonWidget.WIDGETS_LOCATION) {
			AbstractTexture abstractTexture;
			switch (config.customWidgets) {
				case doVanillaTweaksWidgets:
					abstractTexture = new ResourceTexture(vanillaTweaksWidgets);
					break;
				case doTheLegend27Widgets:
					abstractTexture = new ResourceTexture(theLegend27Widgets);
					break;
				case doClassicWidgets:
					abstractTexture = new ResourceTexture(classicWidgets);
					break;
				default:
					abstractTexture = new ResourceTexture(nebulaWidgets);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	private void EnchantmentGlintsController(ModConfig config, Identifier id, CallbackInfo info) {
		if (id == ItemRenderer.ENCHANTED_ITEM_GLINT) {
			AbstractTexture abstractTexture;
			switch (config.customEnchantmentGlints) {
				case doOldGlint:
					abstractTexture = new ResourceTexture(oldGlint);
					break;
				case doClassicGlint:
					abstractTexture = new ResourceTexture(classicGlint);
					break;
				default:
					abstractTexture = new ResourceTexture(gradientGlint);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
}