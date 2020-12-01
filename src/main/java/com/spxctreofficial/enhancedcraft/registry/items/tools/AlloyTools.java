package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class AlloyTools {

	// Tool Materials
	public static class AlloyToolMaterial implements ToolMaterial {
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
			return 0f;
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
	public static class AlloyToolAlternateMaterial implements ToolMaterial {
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
	public static class AlloySwordMaterial implements ToolMaterial {
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
			return Ingredient.ofItems(ECItemRegistry.METAL_ALLOY);
		}
	}

	// Tools
	public static class AlloySwordItem extends SwordItem {
		public AlloySwordItem(ToolMaterial material) {
			super(material, 5, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class AlloyPickaxeItem extends PickaxeItem {
		public AlloyPickaxeItem(ToolMaterial material) {
			super(material, 3, -2.4f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AlloyAxeItem extends AxeItem {
		public AlloyAxeItem(ToolMaterial material) {
			super(material, 8, -3.05f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AlloyShovelItem extends ShovelItem {
		public AlloyShovelItem(ToolMaterial material) {
			super(material, 4, -3f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AlloyHoeItem extends HoeItem {
		public AlloyHoeItem(ToolMaterial material) {
			super(material, 0, -0.5f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
}
