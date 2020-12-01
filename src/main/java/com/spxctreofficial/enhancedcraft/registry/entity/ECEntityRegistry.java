package com.spxctreofficial.enhancedcraft.registry.entity;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ECEntityRegistry {
	// Entity Definitions
	public static final EntityType<HeroBrineEntity> HEROBRINE_ENTITY_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier(EnhancedCraft.MOD_ID, "herobrine"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HeroBrineEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build());
	public static final EntityType<SmartPearlEntity> SMART_PEARL_ENTITY_TYPE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(EnhancedCraft.MOD_ID, "smart_pearl"),
			FabricEntityTypeBuilder.<SmartPearlEntity>create(SpawnGroup.MISC, SmartPearlEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build()
	);

	public static final EntityType<TrollTntEntity> TROLL_TNT_ENTITY_TYPE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(EnhancedCraft.MOD_ID, "troll_tnt"),
			FabricEntityTypeBuilder.<TrollTntEntity>create(SpawnGroup.MISC, TrollTntEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.98F, 0.98F)).trackRangeBlocks(10).trackedUpdateRate(10).build()
	);

	public static void register() {
		// Entity Registry
		FabricDefaultAttributeRegistry.register(HEROBRINE_ENTITY_ENTITY_TYPE, HeroBrineEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D));
	}
}
