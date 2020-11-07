package com.spxctreofficial.enhancedcraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class HeroBrineEntity extends PathAwareEntity {

	public HeroBrineEntity (EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}
}
