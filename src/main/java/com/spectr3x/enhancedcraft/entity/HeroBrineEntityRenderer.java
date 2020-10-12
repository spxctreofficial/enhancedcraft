package com.spectr3x.enhancedcraft.entity;

import com.spectr3x.enhancedcraft.EnhancedCraft;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HeroBrineEntityRenderer extends MobEntityRenderer<HeroBrineEntity, HeroBrineEntityModel> {

	public HeroBrineEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher, new HeroBrineEntityModel(), 0.5f);
	}

	@Override
	public Identifier getTexture(HeroBrineEntity entity) {
		return new Identifier(EnhancedCraft.MOD_ID, "textures/entity/herobrine.png");
	}
}
