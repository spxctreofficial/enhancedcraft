package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ObsidianToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 9366;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 7f;
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
		return 3;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.OBSIDIAN);
	}
    
}
