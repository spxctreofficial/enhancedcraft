package com.spectr3x.enhancedcraft.registry.tools;

import com.spectr3x.enhancedcraft.registry.ModRegistry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BronzeToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 200;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 5f;
	}

	@Override
	public float getAttackDamage() {
		return 0.5f;
	}

	@Override
	public int getMiningLevel() {
		return 2;
	}

	@Override
	public int getEnchantability() {
		return 17;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModRegistry.BronzeIngot);
	}
    
}
