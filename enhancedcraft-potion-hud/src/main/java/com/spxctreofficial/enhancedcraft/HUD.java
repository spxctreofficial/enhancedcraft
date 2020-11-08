package com.spxctreofficial.enhancedcraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.mojang.blaze3d.systems.RenderSystem;
import com.spxctreofficial.enhancedcraft.mixin.MinecraftClientMixin;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Environment(EnvType.CLIENT)
public class HUD {
	/*
	* The code below was originally created by Samuel-Martineau in his Potions-HUD-Fabric Mod, licensed under the MIT License.
	* Huge credit to him for the majority of the code. If you would like to download this as a standalone mod, go to
	* https://github.com/Samuel-Martineau/Potions-HUD-Fabric/blob/master/ or his mod's CurseForge page and download the mod.
	 */
	private MinecraftClient client;

	public HUD() {
		client = MinecraftClient.getInstance();
		HudRenderCallback.EVENT.register((__, ___) -> {
			this.render();
		});
	}

	private void render() {
		final PlayerEntity player = client.player;
		final InGameHud inGameHud = client.inGameHud;
		final TextRenderer textRenderer = client.textRenderer;
		final MatrixStack matrixStack = new MatrixStack();

		if (player == null) return;

		Collection<StatusEffectInstance> statusEffects = player.getStatusEffects();

		final GameOptions gameOptions = ((MinecraftClientMixin) MinecraftClient.getInstance()).getGameOptions();

		if (!statusEffects.isEmpty() && !gameOptions.debugEnabled) {
			RenderSystem.enableBlend();

			StatusEffectSpriteManager statusEffectSpriteManager = client.getStatusEffectSpriteManager();
			List<Runnable> statusEffectsRunnables = Lists.newArrayListWithExpectedSize(statusEffects.size());

			final int spriteSize = 18;

			for (StatusEffectInstance statusEffectInstance : Ordering.natural().reverse().sortedCopy(statusEffects)) {
				StatusEffect statusEffect = statusEffectInstance.getEffectType();

				final int duration = statusEffectInstance.getDuration() / 20;
				final long mins = TimeUnit.SECONDS.toMinutes(duration);
				final long secs = duration - TimeUnit.MINUTES.toSeconds(mins);

				String formattedDuration;
				if (statusEffectInstance.isPermanent()) formattedDuration = "∞";
				else if (mins == 0) formattedDuration = secs + " sec";
				else formattedDuration = String.format("%d min, %d sec", mins, secs);

				final int x = 3;
				final int y = spriteSize * statusEffectsRunnables.size() + 3;

				Sprite sprite = statusEffectSpriteManager.getSprite(statusEffect);

				statusEffectsRunnables.add(() -> {
					client.getTextureManager().bindTexture(sprite.getAtlas().getId());
					DrawableHelper.drawSprite(matrixStack, x, y, inGameHud.getZOffset(), 18, 18, sprite);
					final float textYOffset = spriteSize / 2f - textRenderer.fontHeight / 2.5f;
					int color;
					if (duration <= 5)
						color = 0xFF5555;
					else if (duration <= 15)
						color = 0xFFAA00;
					else if (duration <= 25)
						color = 0xFFFF55;
					else color = 0xFFFFFF;
					textRenderer.draw(matrixStack, formattedDuration, x + spriteSize + 3, y + textYOffset, color);
				});
			}

			statusEffectsRunnables.forEach(Runnable::run);
		}
	}
}
