package com.spectr3x.enhancedcraft.entity;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EtheriumEntityData {
	private static final Map<UUID, EtheriumEntityData> ENTITY_DATA = new HashMap<>();

	public static final short EtheriumEnrageLevel0 = 0;
	public static final short EtheriumEnrageLevel1 = 1;
	public static final short EtheriumEnrageLevel2 = 2;
	public static final short EtheriumEnrageLevel3 = 3;
	public static final short EtheriumMaxEnrageTime = 20 * 5;
	public static final UUID EtheriumHealthBoostUUID = UUID.randomUUID();

	private short EtheriumSetWearingTime = 0;
	private short EtheriumLastBreathCooldown = 600;
	/*private static short EtheriumEnrageLevel = 0;*/

	private short EtheriumEnrageStatus = EtheriumEnrageLevel0;
	private boolean IsEtheriumEnraged = false;
	private short EtheriumEnrageTime = 0;

	private final LivingEntity entity;
	private final LivingEntity victim;

	private void EtheriumSetBonus() {

		EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
		if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

/*		for (ItemStack armorItem : entity.getArmorItems()) {
			if (armorItem.isEmpty()) {
				continue;
			}
			if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
				armorCount++;
			}
		}*/
		AtomicInteger armorCount = new AtomicInteger(0);
		entity.getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
		});
		if (armorCount.get() >= 4) {

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

			entity.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
			if (EtheriumSetWearingTime == 1) {
				maxHealth.removeModifier(EtheriumHealthBoostUUID);
				maxHealth.addTemporaryModifier(new EntityAttributeModifier(EtheriumHealthBoostUUID, "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));

				this.entity.getEntityWorld().playSound(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						this.entity.getBlockPos(), // The position of where the sound will come from
						SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, // The sound that will play
						SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						1.5f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
				);
			}

			if (entity.getHealth() <= 4) {
				if (EtheriumLastBreathCooldown <= 0) {
					EtheriumLastBreathCooldown = 600;
				}

				if (EtheriumLastBreathCooldown == 600) {
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1)));
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 600, 2)));
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)));

					this.entity.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this.entity.getBlockPos(), // The position of where the sound will come from
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
			maxHealth.removeModifier(EtheriumHealthBoostUUID);
			EtheriumSetWearingTime = 0;
		}
	}

	private void EtheriumEnrageMechanic(DamageSource source) {
		AtomicInteger armorCount = new AtomicInteger(0);
		int victimArmorCount = 0;
		if(source != null) {
			Entity attacker = //source.getAttacker();


			if (attacker != null) {
				entity.getArmorItems().forEach(item -> {
					if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
				});

				if(attacker instanceof LivingEntity && !attacker.world.isClient) {
					if(armorCount.get() >= 4) {

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
										attacker.getBlockPos(), // The position of where the sound will come from
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
/*
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
*/
			armorCount.getAndSet(0);
			victim.getArmorItems().forEach(item -> {
				if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
			});
			if (armorCount.get() >= 4) {
				EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

				if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

				maxHealth.removeModifier(EtheriumHealthBoostUUID);
			}
		}
	}

	public EtheriumEntityData(@NotNull LivingEntity entity, @NotNull LivingEntity victim) {
		this.entity = entity;
		this.victim = victim;
		ENTITY_DATA.put(entity.getUuid(), this);
	}

	public static EtheriumEntityData getData(UUID uuid) {
		return ENTITY_DATA.get(uuid);
	}

	public static EtheriumEntityData getData(Entity entity) {
		return getData(entity.getUuid());
	}
}
package com.spectr3x.enhancedcraft.entity;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EtheriumEntityData {
	private static final Map<UUID, EtheriumEntityData> ENTITY_DATA = new HashMap<>();

	public static final short EtheriumEnrageLevel0 = 0;
	public static final short EtheriumEnrageLevel1 = 1;
	public static final short EtheriumEnrageLevel2 = 2;
	public static final short EtheriumEnrageLevel3 = 3;
	public static final short EtheriumMaxEnrageTime = 20 * 5;
	public static final UUID EtheriumHealthBoostUUID = UUID.randomUUID();

	private short EtheriumSetWearingTime = 0;
	private short EtheriumLastBreathCooldown = 600;
	/*private static short EtheriumEnrageLevel = 0;*/

	private short EtheriumEnrageStatus = EtheriumEnrageLevel0;
	private boolean IsEtheriumEnraged = false;
	private short EtheriumEnrageTime = 0;

	private final LivingEntity entity;
	private final LivingEntity victim;

	private void EtheriumSetBonus() {

		EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
		if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

/*		for (ItemStack armorItem : entity.getArmorItems()) {
			if (armorItem.isEmpty()) {
				continue;
			}
			if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
				armorCount++;
			}
		}*/
		AtomicInteger armorCount = new AtomicInteger(0);
		entity.getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
		});
		if (armorCount.get() >= 4) {

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

			entity.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
			if (EtheriumSetWearingTime == 1) {
				maxHealth.removeModifier(EtheriumHealthBoostUUID);
				maxHealth.addTemporaryModifier(new EntityAttributeModifier(EtheriumHealthBoostUUID, "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));

				this.entity.getEntityWorld().playSound(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						this.entity.getBlockPos(), // The position of where the sound will come from
						SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, // The sound that will play
						SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						1.5f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
				);
			}

			if (entity.getHealth() <= 4) {
				if (EtheriumLastBreathCooldown <= 0) {
					EtheriumLastBreathCooldown = 600;
				}

				if (EtheriumLastBreathCooldown == 600) {
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1)));
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 600, 2)));
					entity.addStatusEffect((new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)));

					this.entity.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this.entity.getBlockPos(), // The position of where the sound will come from
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
			maxHealth.removeModifier(EtheriumHealthBoostUUID);
			EtheriumSetWearingTime = 0;
		}
	}

	private void EtheriumEnrageMechanic(DamageSource source) {
		AtomicInteger armorCount = new AtomicInteger(0);
		int victimArmorCount = 0;
		if(source != null) {
			Entity attacker = //source.getAttacker();


			if (attacker != null) {
				entity.getArmorItems().forEach(item -> {
					if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
				});

				if(attacker instanceof LivingEntity && !attacker.world.isClient) {
					if(armorCount.get() >= 4) {

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
										attacker.getBlockPos(), // The position of where the sound will come from
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
/*
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
*/
			armorCount.getAndSet(0);
			victim.getArmorItems().forEach(item -> {
				if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
			});
			if (armorCount.get() >= 4) {
				EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

				if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

				maxHealth.removeModifier(EtheriumHealthBoostUUID);
			}
		}
	}

	public EtheriumEntityData(@NotNull LivingEntity entity, @NotNull LivingEntity victim) {
		this.entity = entity;
		this.victim = victim;
		ENTITY_DATA.put(entity.getUuid(), this);
	}

	public static EtheriumEntityData getData(UUID uuid) {
		return ENTITY_DATA.get(uuid);
	}

	public static EtheriumEntityData getData(Entity entity) {
		return getData(entity.getUuid());
	}
}
