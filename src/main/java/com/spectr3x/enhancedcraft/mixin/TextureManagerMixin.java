package com.spectr3x.enhancedcraft.mixin;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;

import com.spectr3x.enhancedcraft.ModConfig.DisplayBackground;
import com.spectr3x.enhancedcraft.ModConfig.DisplayBackground.CustomBackgrounds;

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
	private static final Identifier defaultTexture = new Identifier("enhancedcraft:textures/gui/options_background_default.png");
	private static final Identifier classicTexture = new Identifier("minecraft:textures/gui/options_background.png");
	private static final Identifier diamondBlockTexture = new Identifier("enhancedcraft:textures/gui/options_background_diamondblock.png");
	private static final Identifier stoneBrickTexture = new Identifier("enhancedcraft:textures/gui/options_background_stonebrick.png");
	private static final Identifier gemstoneTexture = new Identifier("enhancedcraft:textures/gui/options_background_gemstone.png");

	@Inject(
			at = @At(value = "INVOKE", target = "net/minecraft/client/texture/AbstractTexture.bindTexture()V"),
			method = "bindTextureInner(Lnet/minecraft/util/Identifier;)V",
			locals = LocalCapture.CAPTURE_FAILHARD,
			cancellable = true
	)
	private void redirectBackgroundTexture(Identifier id, CallbackInfo info, AbstractTexture abstractTexture) {
		// ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		/*if (id == DrawableHelper.BACKGROUND_TEXTURE && config.displayBackground) {
			abstractTexture = new ResourceTexture(backgroundTexture);
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();

			This doesn't work lol suck it Zero
		}*/

		if (id == DrawableHelper.BACKGROUND_TEXTURE) {
			if (DisplayBackground.customBackgrounds.equals("text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doDefaultBackground")) {
				abstractTexture = new ResourceTexture(defaultTexture);
			}
			else if (DisplayBackground.customBackgrounds.equals("text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doClassicBackground")) {
				abstractTexture = new ResourceTexture(classicTexture);
			}
			else if (DisplayBackground.customBackgrounds.equals("text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doDiamondBackground")) {
				abstractTexture = new ResourceTexture(diamondBlockTexture);
			}
			else if (DisplayBackground.customBackgrounds.equals("text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doStoneBrickBackground")) {
				abstractTexture = new ResourceTexture(stoneBrickTexture);
			}
			else if (DisplayBackground.customBackgrounds.equals("text.autoconfig.enhancedcraft.option.displayBackground.customBackgrounds.doGemstoneBackground")) {
				abstractTexture = new ResourceTexture(gemstoneTexture);
			}
			else {
				abstractTexture = new ResourceTexture(defaultTexture);
			}
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}
	@Shadow
	public void registerTexture (Identifier id, AbstractTexture abstractTexture) {}
}