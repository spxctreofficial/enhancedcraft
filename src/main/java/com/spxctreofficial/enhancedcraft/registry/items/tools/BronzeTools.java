package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class BronzeTools {

	// Tool Materials
	public static class BronzeToolMaterial implements ToolMaterial {
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
			return 0.5f;
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
	public static class BronzeToolAlternateMaterial implements ToolMaterial {
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

	// Tools
	public static class BronzeSwordItem extends SwordItem {
		public BronzeSwordItem(ToolMaterial material) {
			super(material, 4, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class BronzePickaxeItem extends PickaxeItem {
		public BronzePickaxeItem(ToolMaterial material) {
			super(material, 2, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class BronzeAxeItem extends AxeItem {
		public BronzeAxeItem(ToolMaterial material) {
			super(material, 7, -3f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class BronzeShovelItem extends ShovelItem {
		public BronzeShovelItem(ToolMaterial material) {
			super(material, 2, -2.9f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class BronzeHoeItem extends HoeItem {
		public BronzeHoeItem(ToolMaterial material) {
			super(material, 0, -1.5f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
}
