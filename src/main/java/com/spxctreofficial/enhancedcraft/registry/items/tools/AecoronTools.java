package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class AecoronTools {

	// Tool Materials
	public static class AecoronToolMaterial implements ToolMaterial {
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
			return Ingredient.ofItems(ECItemRegistry.AECORON_INGOT);
		}
	}
	public static class AecoronToolAlternateMaterial implements ToolMaterial {
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

	// Tools
	public static class AecoronPickaxeItem extends PickaxeItem {
		public AecoronPickaxeItem(ToolMaterial material) {
			super(material, 4, -2.8f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AecoronAxeItem extends AxeItem {
		public AecoronAxeItem(ToolMaterial material) {
			super(material, 8, -3F, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AecoronShovelItem extends ShovelItem {
		public AecoronShovelItem(ToolMaterial material) {
			super(material, 4, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class AecoronHoeItem extends HoeItem {
		public AecoronHoeItem(ToolMaterial material) {
			super(material, 0, 0f, new Settings().group(ItemGroup.TOOLS));
		}
	}
}
