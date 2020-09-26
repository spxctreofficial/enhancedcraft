package com.spectr3x.enhancedcraft.mixin;

import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntryListWidget.class)
public abstract class EntryListWidgetMixin extends AbstractParentElement implements Drawable{
	@Shadow
	protected final MinecraftClient client;
	private static final Identifier OPTIONS_BACKGROUND = new Identifier("enhancedcraft", "textures/gui/options_background.png");
	private static final Identifier DEFAULT_BACKGROUND = new Identifier("minecraft", "textures/gui/options_background.png");

	public EntryListWidgetMixin(MinecraftClient client, int width, int height, int top, int bottom, int itemHeight) {
		this.client = client;
	}

	@Redirect(method = "render(Lnet/minecraft/client/util/math/MatrixStack;IIF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/TextureManager;bindTexture(Lnet/minecraft/util/Identifier;)V"))
	public void bindTexture(TextureManager textureManager, Identifier id) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		if (config.displayBackground) {
				this.client.getTextureManager().bindTexture(OPTIONS_BACKGROUND);
		} else {
			this.client.getTextureManager().bindTexture(DEFAULT_BACKGROUND);
		}
	}
}
