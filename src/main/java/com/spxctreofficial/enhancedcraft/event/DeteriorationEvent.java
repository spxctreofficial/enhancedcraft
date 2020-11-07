package com.spxctreofficial.enhancedcraft.event;

import com.spxctreofficial.enhancedcraft.registry.ModRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class DeteriorationEvent {

	public static void Deterioration() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
				for (ItemStack armorItem : serverPlayerEntity.getArmorItems()) {
					if (armorItem.isEmpty()) {
						continue;
					}
					if (armorItem.getItem().isIn(ModRegistry.OverworldArmor)) {
						if (serverPlayerEntity.getServerWorld().getRegistryKey() == ModRegistry.MirroredDimension) {
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(ModRegistry.DeteriorationStatusEffect, 2, 0)));
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 2, 4)));
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.HUNGER, 2, 19)));
							break;
						}
					}
				}
				for (ItemStack mainHandItem : serverPlayerEntity.getItemsHand()) {
					if (mainHandItem.isEmpty()) {
						continue;
					}
					if (mainHandItem.getItem().isIn(ModRegistry.OverworldTools)) {
						if (serverPlayerEntity.getServerWorld().getRegistryKey() == ModRegistry.MirroredDimension) {
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 2, 4)));
							serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 2, 0)));
						}
					}
				}
			}
		});
	}
}
