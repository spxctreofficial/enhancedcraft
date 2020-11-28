package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin {

	@Shadow public abstract int getMaxUseTime(ItemStack stack);

	/**
	 * @author Spxctre
	 * @reason In order to make custom Riptide workable without sinking into code for hours upon hours.
	 */
	@Overwrite
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
		if (user instanceof PlayerEntity) {
			PlayerEntity playerEntity = (PlayerEntity) user;
			int i = this.getMaxUseTime(stack) - remainingUseTicks;
			if (i >= 10) {
				int j = EnchantmentHelper.getRiptide(stack);
				if (j <= 0 || playerEntity.isTouchingWaterOrRain()) {
					if (!world.isClient) {
						stack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
						if (j == 0) {
							TridentEntity tridentEntity = new TridentEntity(world, playerEntity, stack);
							tridentEntity.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
							if (playerEntity.abilities.creativeMode) {
								tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
							}

							world.spawnEntity(tridentEntity);
							world.playSoundFromEntity(null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
							if (!playerEntity.abilities.creativeMode) {
								playerEntity.inventory.removeOne(stack);
							}
						}
					}

					playerEntity.incrementStat(Stats.USED.getOrCreateStat(new TridentItem(new Item.Settings())));
					if (j > 0) {
						riptideMechanic(world, playerEntity, j);
					}

				}
			}
		}
	}

	// People are going to hate me, but I'm overwriting lmao

	private void riptideMechanic(World world, PlayerEntity playerEntity, int riptideLevel) {

		// Fields
		float yaw = playerEntity.yaw;
		float pitch = playerEntity.pitch;
		float velX = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
		float velY = -MathHelper.sin(pitch * 0.017453292F);
		float velZ = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
		float idk = MathHelper.sqrt(velX * velX + velY * velY + velZ * velZ);
		float velMultiplier = 3.0F * ((1.0F + (float) riptideLevel) / 4.0F);
		velX *= velMultiplier / idk;
		velY *= velMultiplier / idk;
		velZ *= velMultiplier / idk;

		// Aecoron Riptide Bonus
		aecoronRiptideBonus(world, playerEntity, velX, velY, velZ, velMultiplier);

		// Launches User
		playerEntity.addVelocity(velX, velY, velZ);

		if (playerEntity.isOnGround()) {
			playerEntity.move(MovementType.SELF, new Vec3d(0.0D, 1.1999999284744263D, 0.0D));
		}

		// Play Riptide SoundEvent
		SoundEvent riptideSoundEvent;
		if (riptideLevel >= 3) {
			riptideSoundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
		} else if (riptideLevel == 2) {
			riptideSoundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
		} else {
			riptideSoundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
		}
		world.playSoundFromEntity(null, playerEntity, riptideSoundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
	}

	private void aecoronRiptideBonus(World world, PlayerEntity user, float velX, float velY, float velZ, float velMultiplier) {
		int armorCount = 0;
		for (ItemStack armorItem : user.getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			float aecoronVelMultiplier = 2.5F;

			velX *= aecoronVelMultiplier;
			velY *= aecoronVelMultiplier;
			velZ *= aecoronVelMultiplier;

			user.setRiptideTicks(10);
		}
		else {
			user.setRiptideTicks(20);
		}
	}
}
