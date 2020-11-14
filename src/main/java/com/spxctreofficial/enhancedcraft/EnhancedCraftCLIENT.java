package com.spxctreofficial.enhancedcraft;

import com.spxctreofficial.enhancedcraft.entity.EntitySpawnPacket;
import com.spxctreofficial.enhancedcraft.entity.HeroBrineEntityRenderer;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

public class EnhancedCraftCLIENT implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Entity Registration
		EntityRendererRegistry.INSTANCE.register(ECRegistry.HerobrineEntity, (dispatcher, context) ->
				new HeroBrineEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(ECRegistry.SmartPearlEntityType, (dispatcher, context) ->
				new FlyingItemEntityRenderer(dispatcher, context.getItemRenderer()));
		receiveEntityPacket();
		// AutoConfig1u Registry
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
	}

	public void receiveEntityPacket() {
		ClientSidePacketRegistry.INSTANCE.register(EnhancedCraft.PACKET_ID, (ctx, byteBuf) -> {
			EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
			UUID uuid = byteBuf.readUuid();
			int entityId = byteBuf.readVarInt();
			Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
			float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			ctx.getTaskQueue().execute(() -> {
				if (MinecraftClient.getInstance().world == null)
					throw new IllegalStateException("Tried to spawn entity in a null world!");
				Entity e = et.create(MinecraftClient.getInstance().world);
				if (e == null)
					throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
				e.updateTrackedPosition(pos);
				e.setPos(pos.x, pos.y, pos.z);
				e.pitch = pitch;
				e.yaw = yaw;
				e.setEntityId(entityId);
				e.setUuid(uuid);
				MinecraftClient.getInstance().world.addEntity(entityId, e);
			});
		});
	}
}
