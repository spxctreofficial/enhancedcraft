package com.spectr3x.enhancedcraft.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class HeroBrineEntityModel extends EntityModel<HeroBrineEntity> {
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public HeroBrineEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		head = new ModelPart(this);
		head.setPivot(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		headwear = new ModelPart(this);
		headwear.setPivot(0.0F, 0.0F, 0.0F);
		headwear.setTextureOffset(32, 0).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		body = new ModelPart(this);
		body.setPivot(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(16, 16).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(16, 32).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

		right_arm = new ModelPart(this);
		right_arm.setPivot(-8.0F, 2.0F, 0.0F);
		right_arm.setTextureOffset(40, 16).addCuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		right_arm.setTextureOffset(40, 32).addCuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		left_arm = new ModelPart(this);
		left_arm.setPivot(8.0F, 2.0F, 0.0F);
		left_arm.setTextureOffset(32, 48).addCuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		left_arm.setTextureOffset(48, 48).addCuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		right_leg = new ModelPart(this);
		right_leg.setPivot(-2.0F, 12.0F, 0.0F);
		right_leg.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		right_leg.setTextureOffset(0, 32).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		left_leg = new ModelPart(this);
		left_leg.setPivot(2.0F, 12.0F, 0.0F);
		left_leg.setTextureOffset(16, 48).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		left_leg.setTextureOffset(0, 48).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
	}

	@Override
	public void setAngles (HeroBrineEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		headwear.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}