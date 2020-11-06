package com.spectr3x.enhancedcraft.entity;

import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.interfaces.ECLivingEntity;
import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundCategory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EtheriumEntityData {
	private static final Map<UUID, EtheriumEntityData> ENTITY_DATA = new HashMap<>();
	public static final EtheriumEntityData EMPTY = new EtheriumEntityData();

	public static final short EtheriumMaxEnrageTime = 20 * 5;
	public static final UUID EtheriumHealthBoostUUID = UUID.randomUUID();


	private final ECLivingEntity entity;
	private final ECLivingEntity victim;

	public void EtheriumEnrageMechanic() {
		if (entity == null) {
			EnhancedCraft.LOGGER.warn("A call to the enrage mechanic was called with a nonexistent entity!");
			return;
		}

		AtomicInteger armorCount = new AtomicInteger(0);
		LivingEntity attacker = entity.getAsEntity();

		attacker.getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
		});

		if(!attacker.world.isClient && armorCount.get() == 4) {
			entity.setEtheriumEnrageStatus((short) (entity.getEtheriumEnrageStatus() == 3 ? 3 : entity.getEtheriumEnrageStatus() + 1));
			entity.setEtheriumEnrageTime(EtheriumMaxEnrageTime);


			if (entity.getEtheriumEnrageStatus() == 3) {
				attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, EtheriumMaxEnrageTime, 0));
				attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, EtheriumMaxEnrageTime, 1));

				if (!entity.getIsEtheriumEnrageMaxed()) {
					attacker.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							attacker.getBlockPos(), // The position of where the sound will come from
							ModRegistry.EtheriumEnragedSoundEvent, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
					entity.setIsEtheriumEnrageMaxed(true);
				}
				else {
					attacker.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							attacker.getBlockPos(), // The position of where the sound will come from
							ModRegistry.EtheriumEnragedKillSoundEvent, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
				}
			}

			int amplifier = entity.getEtheriumEnrageStatus() > 1 ? 1 : 0;
			attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, EtheriumMaxEnrageTime, amplifier));
		}

		armorCount.getAndSet(0);
		victim.getAsEntity().getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ModRegistry.EtheriumArmor)) armorCount.incrementAndGet();
		});
		if (armorCount.get() >= 4) {
			EntityAttributeInstance maxHealth = entity.getAsEntity().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

			if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

			maxHealth.removeModifier(EtheriumHealthBoostUUID);
		}
	}


	public EtheriumEntityData(@NotNull ECLivingEntity entity, @NotNull ECLivingEntity victim) {
		this.entity = entity;
		this.victim = victim;
		ENTITY_DATA.put(entity.getAsEntity().getUuid(), this);
	}

	private EtheriumEntityData() {
		this.entity = null;
		this.victim = null;
	}

	public static EtheriumEntityData getData(UUID uuid) {
		return ENTITY_DATA.getOrDefault(uuid, EMPTY);
	}

	public static EtheriumEntityData getData(Entity entity) {
		return getData(entity.getUuid());
	}
}
