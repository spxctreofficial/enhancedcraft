package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class NetherrackToolAlternateMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 72;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 3.2f;
	}

	@Override
	public float getAttackDamage() {
		return 0f;
	}

	@Override
	public int getMiningLevel() {
		return 1;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.NETHERRACK);
	}
    
}
