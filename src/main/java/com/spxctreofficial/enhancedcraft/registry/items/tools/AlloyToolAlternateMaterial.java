package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AlloyToolAlternateMaterial implements ToolMaterial {

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
		return 0.5f;
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
		return Ingredient.ofItems(ECItemRegistry.METAL_ALLOY);
	}
    
}
