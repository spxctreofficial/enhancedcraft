package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

	Random rand = new Random();

	@Shadow public abstract String getEntityName();

	@Inject(method = "dropInventory", at = @At("HEAD"))
	private void dropInventory(CallbackInfo info) {
		playerHeadDrop();
		dropPrimeApple();
	}

	// Private methods to clean-up code

	private void playerHeadDrop() {
		if (rand.nextFloat() <= 0.50F) {
			Entity entity = (LivingEntity) (Object) this;
			String entityName = entity.getEntityName();

			ItemEntity itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Items.PLAYER_HEAD));
			CompoundTag SkullOwnerTag = itemEntity.getStack().getOrCreateTag();

			SkullOwnerTag.putString("SkullOwner", entityName);

			itemEntity.setToDefaultPickupDelay();
			entity.world.spawnEntity(itemEntity);
		}
	}

	private void dropPrimeApple() {
		Entity entity = (LivingEntity) (Object) this;
		String entityName = entity.getEntityName();
		if (entityName.equals("Spxctre") && rand.nextFloat() == 1F) {
			ItemEntity itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ECRegistry.PRIMORDIAL_CATALYST));
			itemEntity.setToDefaultPickupDelay();
			entity.world.spawnEntity(itemEntity);
		}
	}
}
