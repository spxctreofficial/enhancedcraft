//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spxctreofficial.enhancedcraft.entity;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SmartPearlEntity extends ThrownItemEntity {
	public SmartPearlEntity(EntityType<? extends SmartPearlEntity> entityType, World world) {
		super(entityType, world);
	}

	public SmartPearlEntity(World world, LivingEntity owner) {
		super(ECRegistry.SmartPearlEntityType, owner, world);
	}

	@Environment(EnvType.CLIENT)
	public SmartPearlEntity(World world, double x, double y, double z) {
		super(ECRegistry.SmartPearlEntityType, x, y, z, world);
	}

	protected Item getDefaultItem() {
		return ECRegistry.SmartPearlItem;
	}

	@Override
	public Packet createSpawnPacket() {
		return EntitySpawnPacket.create(this, EnhancedCraft.PACKET_ID);
	}

	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 3.0F);
	}

	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		Entity entity = this.getOwner();

		for(int i = 0; i < 100; ++i) {
			this.world.addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
		}

		if (!this.world.isClient && !this.removed) {
			if (entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
				if (serverPlayerEntity.networkHandler.getConnection().isOpen() && serverPlayerEntity.world == this.world && !serverPlayerEntity.isSleeping()) {
					if (entity.hasVehicle()) {
						entity.stopRiding();
					}
					entity.requestTeleport(this.getX(), this.getY(), this.getZ());
					entity.fallDistance = 0F;
					world.playSound(null, this.getX(), this.getY(), this.getZ(), ECRegistry.SmartPearlTeleportSoundEvent, SoundCategory.NEUTRAL, 0.75F, 1F);
				}
			} else if (entity != null) {
				entity.requestTeleport(this.getX(), this.getY(), this.getZ());
				entity.fallDistance = 0F;
			}
			this.remove();
		}

	}

	public void tick() {
		Entity entity = this.getOwner();
		if (entity instanceof PlayerEntity && !entity.isAlive()) {
			this.remove();
		} else {
			super.tick();
		}

	}

	@Nullable
	public Entity moveToWorld(ServerWorld destination) {
		Entity entity = this.getOwner();
		if (entity != null && entity.world.getRegistryKey() != destination.getRegistryKey()) {
			this.setOwner((Entity)null);
		}
		return super.moveToWorld(destination);
	}
}
