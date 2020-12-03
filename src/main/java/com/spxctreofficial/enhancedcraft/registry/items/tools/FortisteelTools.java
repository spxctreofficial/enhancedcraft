package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class FortisteelTools {

	// Tool Materials
	public static class FortisteelToolMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 384;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6.5F;
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
			return Ingredient.ofItems(ECItemRegistry.FORTISTEEL_INGOT);
		}
	}
	public static class FortisteelToolAlternateMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 384;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6.5F;
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
			return Ingredient.ofItems(ECItemRegistry.FORTISTEEL_INGOT);
		}
	}

	// Tools
	public static class FortisteelSwordItem extends SwordItem {
		public FortisteelSwordItem(ToolMaterial material) {
			super(material, 5, -2.4f, new Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class FortisteelPickaxeItem extends PickaxeItem {
		public FortisteelPickaxeItem(ToolMaterial material) {
			super(material, 3, -2.8f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class FortisteelAxeItem extends AxeItem {
		public FortisteelAxeItem(ToolMaterial material) {
			super(material, 8, -3.1f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class FortisteelShovelItem extends ShovelItem {
		public FortisteelShovelItem(ToolMaterial material) {
			super(material, 4, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class FortisteelHoeItem extends HoeItem {
		public FortisteelHoeItem(ToolMaterial material) {
			super(material, 0, -0.3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
}
