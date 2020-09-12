package com.spectr3x.enhancedcraft.registry.tools;

import com.spectr3x.enhancedcraft.registry.ModRegistry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EtheriumToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 1796;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 28f;
	}

	@Override
	public float getAttackDamage() {
		return 0f;
	}

	@Override
	public int getMiningLevel() {
		return 7;
	}

	@Override
	public int getEnchantability() {
		return 35;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModRegistry.Etherium);
	}
    
}
