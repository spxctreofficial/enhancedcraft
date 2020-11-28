package com.spxctreofficial.enhancedcraft.registry.tools;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AecoronToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 1248;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 8f;
	}

	@Override
	public float getAttackDamage() {
		return 0f;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public int getEnchantability() {
		return 14;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ECRegistry.AECORON_INGOT);
	}
    
}
