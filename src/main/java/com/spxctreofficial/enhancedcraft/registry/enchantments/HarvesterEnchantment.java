package com.spxctreofficial.enhancedcraft.registry.enchantments;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class HarvesterEnchantment extends Enchantment {
	public HarvesterEnchantment() {
		super(Rarity.UNCOMMON, ClassTinkerers.getEnum(EnchantmentTarget.class, "HOE"), new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMinPower(int level) {
		return 15;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != Enchantments.FORTUNE;
	}
}
