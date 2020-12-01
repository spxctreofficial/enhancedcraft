package com.spxctreofficial.enhancedcraft.registry.entity;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
import com.spxctreofficial.enhancedcraft.registry.sounds.ECSoundRegistry;
import com.spxctreofficial.enhancedcraft.registry.tags.ECTagRegistry;
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

	public static final short ETHERIUM_MAX_ENRAGE_TIME = 20 * 5;
	public static final UUID ETHERIUM_HEALTH_BOOST_UUID = UUID.randomUUID();

	private final ECLivingEntity user;
	private final ECLivingEntity victim;

	public void etheriumEnrageMechanic() {
		if (user == null) {
			EnhancedCraft.LOGGER.warn("A call to the enrage mechanic was called with a nonexistent entity!");
			return;
		}

		AtomicInteger armorCount = new AtomicInteger(0);
		LivingEntity attacker = user.getAsEntity();

		attacker.getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ECTagRegistry.ETHERIUM_ARMOR)) armorCount.incrementAndGet();
		});

		if(!attacker.world.isClient && armorCount.get() == 4) {
			user.setEtheriumEnrageStatus((short) (user.getEtheriumEnrageStatus() == 3 ? 3 : user.getEtheriumEnrageStatus() + 1));
			user.setEtheriumEnrageTime(ETHERIUM_MAX_ENRAGE_TIME);


			if (user.getEtheriumEnrageStatus() == 3) {
				attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, ETHERIUM_MAX_ENRAGE_TIME, 0));
				attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, ETHERIUM_MAX_ENRAGE_TIME, 1));

				if (!user.getIsEtheriumEnrageMaxed()) {
					attacker.getEntityWorld().playSoundFromEntity(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							attacker, // The position of where the sound will come from
							ECSoundRegistry.ETHERIUM_ENRAGED_SOUND_EVENT, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
					user.setIsEtheriumEnrageMaxed(true);
				}
				else {
					attacker.getEntityWorld().playSoundFromEntity(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							attacker, // The position of where the sound will come from
							ECSoundRegistry.ETHERIUM_ENRAGED_KILL_SOUND_EVENT, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
				}
			}

			int amplifier = user.getEtheriumEnrageStatus() > 1 ? 1 : 0;
			attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, ETHERIUM_MAX_ENRAGE_TIME, amplifier));
		}

		armorCount.getAndSet(0);
		victim.getAsEntity().getArmorItems().forEach(item -> {
			if (!item.isEmpty() && item.getItem().isIn(ECTagRegistry.ETHERIUM_ARMOR)) armorCount.incrementAndGet();
		});
		if (armorCount.get() >= 4) {
			EntityAttributeInstance maxHealth = user.getAsEntity().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

			if (maxHealth == null) throw new RuntimeException("An entity's max health should not be null!");

			maxHealth.removeModifier(ETHERIUM_HEALTH_BOOST_UUID);
		}
	}


	public EtheriumEntityData(@NotNull ECLivingEntity user, @NotNull ECLivingEntity victim) {
		this.user = user;
		this.victim = victim;
		ENTITY_DATA.put(user.getAsEntity().getUuid(), this);
	}

	private EtheriumEntityData() {
		this.user = null;
		this.victim = null;
	}

	public static EtheriumEntityData getData(UUID uuid) {
		return ENTITY_DATA.getOrDefault(uuid, EMPTY);
	}

	public static EtheriumEntityData getData(Entity entity) {
		return getData(entity.getUuid());
	}
}
