package com.spxctreofficial.enhancedcraft.registry.statusEffects;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ECStatusEffectRegistry {
	// Status Effect Definitions
	public static final StatusEffect DETERIORATION_STATUS_EFFECT = new DeteriorationStatusEffect();

	public static void register() {
		// Status Effect Registry
		Registry.register(Registry.STATUS_EFFECT, new Identifier(EnhancedCraft.MOD_ID, "deterioration"), DETERIORATION_STATUS_EFFECT);
	}
}
