package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AecoronToolAlternateMaterial implements ToolMaterial {

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
		return 0.5f;
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
		return Ingredient.ofItems(ECItemRegistry.AECORON_INGOT);
	}
    
}
