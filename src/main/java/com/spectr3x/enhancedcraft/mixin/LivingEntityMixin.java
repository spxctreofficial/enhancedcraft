package com.spectr3x.enhancedcraft.mixin;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(method = "onDeath", at = @At("RETURN"))
	public void onDeath(DamageSource source, CallbackInfo info) {

		EtheriumEnrageMechanic(source);

	}


	// Private voids to clean up the code


	private void EtheriumEnrageMechanic(DamageSource source) {
		int armorCount = 0;

		if(source != null) {
			Entity attacker = source.getAttacker();

			if (attacker != null) {
				for (ItemStack armorItem : attacker.getArmorItems()) {
					if (armorItem.isEmpty()) {
						continue;
					}
					if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
						armorCount++;
					}
				}

				if(attacker instanceof PlayerEntity && !attacker.world.isClient) {
					if(armorCount >= 4) {
						((PlayerEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 1));
						((PlayerEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 5, 1));

						attacker.playSound(SoundEvents.ITEM_TRIDENT_THUNDER, 1f, 0.65f);

						attacker.world.playSound(
								null, // Player - if non-null, will play sound for every nearby player *except* the specified player
								attacker.getBlockPos(), // The position of where the sound will come from
								SoundEvents.ITEM_TRIDENT_THUNDER, // The sound that will play
								SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
								1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
								0.65f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
						);
					}
				}
			}
		}
	}
}
