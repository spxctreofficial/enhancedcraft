package com.spectr3x.enhancedcraft.mixin;

import com.spectr3x.enhancedcraft.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.DrawableHelper;
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
	private static final Identifier backgroundTexture = new Identifier("enhancedcraft:textures/gui/options_background.png");
	private static final Identifier defaultTexture = new Identifier("minecraft:textures/gui/options_background.png");

	@Inject(
		at = @At(value = "INVOKE", target = "net/minecraft/client/texture/AbstractTexture.bindTexture()V"),
		method = "bindTextureInner(Lnet/minecraft/util/Identifier;)V",
		locals = LocalCapture.CAPTURE_FAILHARD,
		cancellable = true
	)
	private void redirectBackgroundTexture(Identifier id, CallbackInfo info, AbstractTexture abstractTexture) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		if (id == DrawableHelper.BACKGROUND_TEXTURE && config.displayBackground) {
			abstractTexture = new ResourceTexture(backgroundTexture);
			this.registerTexture(id, abstractTexture);
			abstractTexture.bindTexture();
			info.cancel();
		}
	}

	@Shadow
	public void registerTexture (Identifier id, AbstractTexture abstractTexture) {}
}