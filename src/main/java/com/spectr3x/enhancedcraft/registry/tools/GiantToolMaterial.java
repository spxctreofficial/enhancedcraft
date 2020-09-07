package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GiantToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 676;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 6f;
	}

	@Override
	public float getAttackDamage() {
		return 0.5f;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public int getEnchantability() {
		return 13;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}
    
}
