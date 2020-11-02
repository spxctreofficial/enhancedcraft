package com.spectr3x.enhancedcraft.mixin;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	private short EtheriumLastBreathCooldown;
	private short EtheriumSetWearingTime;
	/*private static short EtheriumEnrageLevel = 0;*/

	private short EtheriumEnrageLevel0;
	private short EtheriumEnrageLevel1;
	private short EtheriumEnrageLevel2;
	private short EtheriumEnrageLevel3;

	private short EtheriumMaxEnrageTime;

	private short EtheriumEnrageStatus;
	private boolean IsEtheriumEnraged;
	private short EtheriumEnrageTime;

	private UUID EtheriumHealthBoostUUID;

	@Shadow public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

	// @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

	@Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

	@Shadow public abstract float getHealth();

	@Inject(method = "<init>", at = @At("TAIL"))
	private void init(CallbackInfo info) {
		EtheriumLastBreathCooldown = 600;
		EtheriumSetWearingTime = 0;

		EtheriumEnrageLevel0 = 0;
		EtheriumEnrageLevel1 = 1;
		EtheriumEnrageLevel2 = 2;
		EtheriumEnrageLevel3 = 3;

		EtheriumMaxEnrageTime = 20 * 5;

		EtheriumEnrageStatus = EtheriumEnrageLevel0;
		boolean IsEtheriumEnraged = false;
		EtheriumEnrageTime = 0;

		EtheriumHealthBoostUUID = UUID.randomUUID(); // hope to god that this works
	}

	@Inject(method = "onDeath", at = @At("RETURN"))
	public void onDeath(DamageSource source, CallbackInfo info) {
		EtheriumEnrageMechanic(source);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo info) {
		EtheriumSetBonus();
	}

	// Private voids to clean up the code

	private void EtheriumSetBonus() {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				continue;
			}
			if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			if (EtheriumSetWearingTime < 3) {
				EtheriumSetWearingTime++;
			}

			if (EtheriumEnrageTime > 0) {
				EtheriumEnrageTime--;
			}
			else {
				EtheriumEnrageStatus = EtheriumEnrageLevel0;
				IsEtheriumEnraged = false;
			}

			addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
			if (EtheriumSetWearingTime == 1) {
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EtheriumHealthBoostUUID);
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(new EntityAttributeModifier(EtheriumHealthBoostUUID, "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));

				((Entity)(Object)this).getEntityWorld().playSound(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						((Entity)(Object)this).getBlockPos(), // The position of where the sound will come from
						SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, // The sound that will play
						SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						1.5f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
				);
			}

			if (getHealth() <= 4) {
				if (EtheriumLastBreathCooldown <= 0) {
					EtheriumLastBreathCooldown = 600;
				}

				if (EtheriumLastBreathCooldown == 600) {
					addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1)));
					addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 600, 2)));
					addStatusEffect((new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)));

					((Entity)(Object)this).getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							((Entity)(Object)this).getBlockPos(), // The position of where the sound will come from
							SoundEvents.ITEM_TRIDENT_RETURN, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1.25f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);

				}
				EtheriumLastBreathCooldown -= 1;
			}
			else {
				EtheriumLastBreathCooldown = 600;
			}
		}
		else {
			getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EtheriumHealthBoostUUID);
			EtheriumSetWearingTime = 0;
		}
	}

	private void EtheriumEnrageMechanic(DamageSource source) {
		int armorCount = 0;
		int victimArmorCount = 0;
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

				if(attacker instanceof LivingEntity && !attacker.world.isClient) {
					if(armorCount == 4) {

						EtheriumEnrageTime = EtheriumMaxEnrageTime;
						IsEtheriumEnraged = true;

						if (IsEtheriumEnraged) {

							int amplifier;

							if (EtheriumEnrageStatus == EtheriumEnrageLevel3) {

								amplifier = 2;

								((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, EtheriumMaxEnrageTime, amplifier));
								((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, EtheriumMaxEnrageTime, amplifier));

								attacker.getEntityWorld().playSound(
										null, // Player - if non-null, will play sound for every nearby player *except* the specified player
										((Entity)(Object)this).getBlockPos(), // The position of where the sound will come from
										SoundEvents.ITEM_TRIDENT_THUNDER, // The sound that will play
										SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
										1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
										0.35f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
								);
							}
							else if (EtheriumEnrageStatus == EtheriumEnrageLevel2) {
								EtheriumEnrageStatus = EtheriumEnrageLevel3;
								amplifier = 1;
							}
							else if (EtheriumEnrageStatus == EtheriumEnrageLevel1) {
								EtheriumEnrageStatus = EtheriumEnrageLevel2;
								amplifier = 0;
							}

							else if (EtheriumEnrageStatus == EtheriumEnrageLevel0) {
								EtheriumEnrageStatus = EtheriumEnrageLevel1;
								amplifier = 0;
							}
							else {
								EtheriumEnrageStatus = EtheriumEnrageLevel0;
								amplifier = 0;
							}
							((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, amplifier));
						}
						/*EtheriumEnrageLevel++;*/

						/*if (EtheriumEnrageLevel >= 2) {
						*	amplifier = 1;
						*	if (EtheriumEnrageLevel >= 3) {
						*		if (EtheriumEnrageLevel == 3) {
						*			attacker.world.playSound(
						*					null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						*					attacker.getBlockPos(), // The position of where the sound will come from
						*					SoundEvents.ITEM_TRIDENT_THUNDER, // The sound that will play
						*					SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						*					1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						*					0.35f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
						*			);
						*		}
						*		((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 5, amplifier));
						*		((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20 * 5, amplifier));
						*	}
						}*/
					}
				}
			}
			for (ItemStack victimArmorItem : getArmorItems()) {
				if (victimArmorItem.isEmpty()) {
					continue;
				}
				if (victimArmorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
					victimArmorCount++;
				}
			}
			if (victimArmorCount == 4) {
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EtheriumHealthBoostUUID);
				EtheriumSetWearingTime = 0;
			}
		}
	}

	private LivingEntityMixin() {
		super(null, null);
	}
}
