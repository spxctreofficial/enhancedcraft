package com.spxctreofficial.enhancedcraft.registry.enchantments;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

public class HoeEnchantmentTarget extends EnchantmentTargetMixin {
	@Override
	public boolean isAcceptableItem(Item item) {
		return item instanceof HoeItem;
	}
}

@Mixin(EnchantmentTarget.class)
abstract class EnchantmentTargetMixin {
	@Shadow
	abstract boolean isAcceptableItem(Item item);
}
