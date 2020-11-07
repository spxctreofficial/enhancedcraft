package com.spxctreofficial.enhancedcraft.registry.tools;

import com.spxctreofficial.enhancedcraft.registry.ModRegistry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AlloySwordMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 750;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 7.5f;
	}

	@Override
	public float getAttackDamage() {
		return 0.7f;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public int getEnchantability() {
		return 22;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModRegistry.MetalAlloy);
	}
    
}
