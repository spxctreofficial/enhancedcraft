package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import com.spxctreofficial.enhancedcraft.registry.tags.ECTagRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

	final Random rand = new Random();

	@Shadow protected abstract void damageShield(float amount);

	@Shadow public abstract boolean damage(DamageSource source, float amount);

	@Inject(method = "dropInventory", at = @At("HEAD"))
	private void dropInventory(CallbackInfo info) {
		playerHeadDrop();
		dropPrimeApple();
	}

	@Inject(method = "takeShieldHit", at = @At("HEAD"))
	private void takeShieldHit(LivingEntity attacker, CallbackInfo info) {

		ECLivingEntity ecLivingEntity = (ECLivingEntity) attacker;
		PlayerEntity victim = (PlayerEntity) (Object) this;

		int armorCount = 0;
		for (ItemStack armorItem : attacker.getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECTagRegistry.ETHERIUM_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			if (ecLivingEntity.getIsEtheriumEnrageMaxed() && (attacker.getMainHandStack().getItem() instanceof SwordItem || attacker.getMainHandStack().getItem() instanceof AxeItem)) {

				SwordItem item = (SwordItem) attacker.getMainHandStack().getItem();
				float damageDealt = item.getAttackDamage();

				superDisableShield(victim);
				this.damage(DamageSource.player((PlayerEntity) attacker), damageDealt);
			}
			info.cancel();
		}
	}

	@Inject(method = "getBlockBreakingSpeed", at = @At("HEAD"), cancellable = true)
	private void getBlockBreakingSpeed(BlockState blockState, CallbackInfoReturnable<Float> callbackInfoReturnable) {

		PlayerEntity playerEntity = (PlayerEntity) (Object) this;
		ItemStack itemStack = playerEntity.getMainHandStack();
		float breakingSpeed = playerEntity.inventory.getBlockBreakingSpeed(blockState);

		if (playerEntity.isTouchingWater() && itemStack.getItem().isIn(ECTagRegistry.IS_WATER_FATIGUE_IMMUNE)) {
			callbackInfoReturnable.setReturnValue(breakingSpeed);
		}
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
			ItemEntity itemEntity = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ECItemRegistry.PRIMORDIAL_CATALYST));
			itemEntity.setToDefaultPickupDelay();
			entity.world.spawnEntity(itemEntity);
		}
	}

	private void superDisableShield(PlayerEntity playerEntity) {
		playerEntity.getItemCooldownManager().set(Items.SHIELD, 20 * 20);
		this.damageShield(125F);
		playerEntity.clearActiveItem();
		playerEntity.world.sendEntityStatus(playerEntity, (byte)30);
	}
}
