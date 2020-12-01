package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BronzeToolAlternateMaterial implements ToolMaterial {

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
		return 0f;
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
		return Ingredient.ofItems(ECItemRegistry.BRONZE_INGOT);
	}
    
}
