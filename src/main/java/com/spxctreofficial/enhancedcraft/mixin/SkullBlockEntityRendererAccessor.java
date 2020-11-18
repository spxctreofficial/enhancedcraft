package com.spxctreofficial.enhancedcraft.mixin;

import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(SkullBlockEntityRenderer.class)
public interface SkullBlockEntityRendererAccessor {
	@Accessor("MODELS")
	static Map<SkullBlock.SkullType, SkullEntityModel> getModels() {
		return null;
	}

	@Accessor("TEXTURES")
	static Map<SkullBlock.SkullType, Identifier> getTextures() {
		return null;
	}
}
