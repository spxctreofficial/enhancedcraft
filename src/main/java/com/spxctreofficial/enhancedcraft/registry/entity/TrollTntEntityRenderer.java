package com.spxctreofficial.enhancedcraft.registry.entity;

import com.spxctreofficial.enhancedcraft.registry.blocks.ECBlockRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class TrollTntEntityRenderer extends EntityRenderer<TrollTntEntity> {
	public TrollTntEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher);
		this.shadowRadius = 0.5F;
	}

	public void render(TrollTntEntity tntEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		matrixStack.push();
		matrixStack.translate(0.0D, 0.5D, 0.0D);
		if ((float)tntEntity.getFuseTimer() - g + 1.0F < 10.0F) {
			float h = 1.0F - ((float)tntEntity.getFuseTimer() - g + 1.0F) / 10.0F;
			h = MathHelper.clamp(h, 0.0F, 1.0F);
			h *= h;
			h *= h;
			float j = 1.0F + h * 0.3F;
			matrixStack.scale(j, j, j);
		}

		matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-90.0F));
		matrixStack.translate(-0.5D, -0.5D, 0.5D);
		matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
		TntMinecartEntityRenderer.renderFlashingBlock(ECBlockRegistry.TROLL_TNT_BLOCK.getDefaultState(), matrixStack, vertexConsumerProvider, i, tntEntity.getFuseTimer() % 2 == 0);
		matrixStack.pop();
		super.render(tntEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}

	@Override
	public Identifier getTexture(TrollTntEntity entity) {
		return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
	}
}
