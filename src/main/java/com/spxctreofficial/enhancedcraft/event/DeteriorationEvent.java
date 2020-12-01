package com.spxctreofficial.enhancedcraft.event;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class DeteriorationEvent {

	public static void deterioration() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
				for (ItemStack armorItem : serverPlayerEntity.getArmorItems()) {
					if (armorItem.isEmpty() || EnchantmentHelper.getLevel(ECRegistry.purifiedEnchantment, armorItem) > 0) {
						continue;
					}
					if (armorItem.getItem().isIn(ECRegistry.OVERWORLD_ARMOR)
							&& serverPlayerEntity.getServerWorld().getRegistryKey() == ECRegistry.MIRRORED_DIMENSION) {
						armorDeterioriate(serverPlayerEntity);
						break;
					}
				}
				for (ItemStack mainHandItem : serverPlayerEntity.getItemsHand()) {
					if (mainHandItem.isEmpty() || EnchantmentHelper.getLevel(ECRegistry.purifiedEnchantment, mainHandItem) > 0) {
						continue;
					}
					if (mainHandItem.getItem().isIn(ECRegistry.OVERWORLD_TOOLS)
							&& serverPlayerEntity.getServerWorld().getRegistryKey() == ECRegistry.MIRRORED_DIMENSION) {
						itemDeterioriate(serverPlayerEntity);
						break;
					}
				}
			}
		});
	}

	private static void armorDeterioriate(ServerPlayerEntity serverPlayerEntity) {
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(ECRegistry.DETERIORATION_STATUS_EFFECT, 2, 0)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 2, 4)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.HUNGER, 2, 19)));
	}

	private static void itemDeterioriate(ServerPlayerEntity serverPlayerEntity) {
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 2, 4)));
		serverPlayerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 2, 0)));
	}
}
