package com.spectr3x.enhancedcraft;

import com.spectr3x.enhancedcraft.entity.HeroBrineEntity;
import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancedCraft implements ModInitializer {
	public static final String MOD_ID = "enhancedcraft";
	public static final Logger logger = LogManager.getLogger(MOD_ID);

	public static final EntityType<HeroBrineEntity> HEROBRINE = Registry.register(
		Registry.ENTITY_TYPE,
		new Identifier(MOD_ID, "herobrine"),
		FabricEntityTypeBuilder.<HeroBrineEntity>create(SpawnGroup.CREATURE, HeroBrineEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build()
	);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(HEROBRINE, HeroBrineEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1));
		ModRegistry.registry();
	}
}
