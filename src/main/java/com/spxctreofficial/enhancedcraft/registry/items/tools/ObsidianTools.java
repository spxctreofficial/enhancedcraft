package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class ObsidianTools {

	// Tool Materials
	public static class ObsidianToolMaterial implements ToolMaterial {
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

	// Tools
	public static class ObsidianSwordItem extends SwordItem {
		public ObsidianSwordItem(ToolMaterial material) {
			super(material, 7, -2.65f, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
		}
	}
	public static class ObsidianPickaxeItem extends PickaxeItem {
		public ObsidianPickaxeItem(ToolMaterial material) {
			super(material, 5, -3f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
		}
	}
	public static class ObsidianAxeItem extends AxeItem {
		public ObsidianAxeItem(ToolMaterial material) {
			super(material, 9, -3.2f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
		}
	}
	public static class ObsidianShovelItem extends ShovelItem {
		public ObsidianShovelItem(ToolMaterial material) {
			super(material, 5, -3f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
		}
	}
	public static class ObsidianHoeItem extends HoeItem {
		public ObsidianHoeItem(ToolMaterial material) {
			super(material, 2, -1.2f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
		}
	}
}
