package com.spectr3x.enhancedcraft;

import com.spectr3x.enhancedcraft.entity.HeroBrineEntityRenderer;
import com.spectr3x.enhancedcraft.registry.ModRegistry;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EnhancedCraftCLIENT implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Entity Registration
		EntityRendererRegistry.INSTANCE.register(ModRegistry.HerobrineEntity, (dispatcher, context) -> {
			return new HeroBrineEntityRenderer(dispatcher);
		});
		// AutoConfig1u Registry
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
	}
}
