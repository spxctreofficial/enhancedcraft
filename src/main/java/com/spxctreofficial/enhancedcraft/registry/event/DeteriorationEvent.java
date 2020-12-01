package com.spxctreofficial.enhancedcraft.registry.event;

import com.spxctreofficial.enhancedcraft.registry.enchantments.ECEnchantmentRegistry;
import com.spxctreofficial.enhancedcraft.registry.statusEffects.ECStatusEffectRegistry;
import com.spxctreofficial.enhancedcraft.registry.tags.ECTagRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class DeteriorationEvent {

	public static void deterioration() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
				for (ItemStack armorItem : serverPlayerEntity.getArmorItems()) {
					if (armorItem.isEmpty() || EnchantmentHelper.getLevel(ECEnchantmentRegistry.purifiedEnchantment, armorItem) > 0) {
						continue;
					}
					if (armorItem.getItem().isIn(ECTagRegistry.OVERWORLD_ARMOR)
							&& serverPlayerEntity.getServerWorld().getRegistryKey() == ECTagRegistry.MIRRORED_DIMENSION) {
						armorDeterioriate(serverPlayerEntity);
						break;
					}
				}
				for (ItemStack mainHandItem : serverPlayerEntity.getItemsHand()) {
					if (mainHandItem.isEmpty() || EnchantmentHelper.getLevel(ECEnchantmentRegistry.purifiedEnchantment, mainHandItem) > 0) {
						continue;
					}
					if (mainHandItem.getItem().isIn(ECTagRegistry.OVERWORLD_TOOLS)
							&& serverPlayerEntity.getServerWorld().getRegistryKey() == ECTagRegistry.MIRRORED_DIMENSION) {
						itemDeterioriate(serverPlayerEntity);
						break;
					}
				}
			}
		});
	}

	private static void armorDeterioriate(ServerPlayerEntity serverPlayerEntity) {
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(ECStatusEffectRegistry.DETERIORATION_STATUS_EFFECT, 2, 0)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 2, 4)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.HUNGER, 2, 19)));
	}

	private static void itemDeterioriate(ServerPlayerEntity serverPlayerEntity) {
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 2, 4)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 2, 0)));
	}
}
