package com.spxctreofficial.enhancedcraft.registry.entity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;

public class SmartPearlEntityRenderer extends FlyingItemEntityRenderer<SmartPearlEntity> {
	public SmartPearlEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, ItemRenderer itemRenderer) {
		super(entityRenderDispatcher, itemRenderer);
	}
}
