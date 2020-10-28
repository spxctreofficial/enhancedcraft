package com.spectr3x.enhancedcraft.event.bonuses.armorBonuses;

import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.UUID;

public class EtheriumSetBonus {
	public static short EtheriumAbsorptionCooldown = 600;
	public static short EtheriumSetBonusAge = 0;

	public static void SetBonus() { // I love code
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
				int armorCount = 0;
				for (ItemStack armorItem : serverPlayerEntity.getArmorItems()) {
					if (armorItem.isEmpty()) {
						continue;
					}
					if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
						armorCount++;
					}
				}

				if (armorCount >= 4) {
					EtheriumSetBonusAge++;
					if (EtheriumSetBonusAge > 3) {
						EtheriumSetBonusAge = 3;
					}

					serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
					if (EtheriumSetBonusAge == 1) {
						serverPlayerEntity
								.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
								.addTemporaryModifier(new EntityAttributeModifier(UUID.fromString("cd942309-c31e-4044-896d-20135ada7cb3"), "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));
					}

					if (serverPlayerEntity.getHealth() <= 4) {
						if (EtheriumAbsorptionCooldown <= 0) {
							EtheriumAbsorptionCooldown = 600;
						}

						if (EtheriumAbsorptionCooldown == 600) {
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1)));
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 600, 2)));
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)));

							serverPlayerEntity.getServerWorld().playSound(
									null, // Player - if non-null, will play sound for every nearby player *except* the specified player
									serverPlayerEntity.getBlockPos(), // The position of where the sound will come from
									SoundEvents.ITEM_TRIDENT_RETURN, // The sound that will play
									SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
									1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
									1.25f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
							);

						}
						EtheriumAbsorptionCooldown -= 1;
					}
					else {
						EtheriumAbsorptionCooldown = 600;
					}
				}
				else {
					serverPlayerEntity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
							.removeModifier(UUID.fromString("cd942309-c31e-4044-896d-20135ada7cb3"));
					EtheriumSetBonusAge = 0;
				}
			}
		});
	}
}
