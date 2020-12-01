package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class NetherrackTools {

	// Tool Materials
	public static class NetherrackToolMaterial implements ToolMaterial {
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
			return 0.5f;
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
	public static class NetherrackToolAlternateMaterial implements ToolMaterial {
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

	// Tools
	public static class NetherrackSwordItem extends SwordItem {
		public NetherrackSwordItem(ToolMaterial material) {
			super(material, 3, -2.4f, new Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class NetherrackPickaxeItem extends PickaxeItem {
		public NetherrackPickaxeItem(ToolMaterial material) {
			super(material, 1, -2.8f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class NetherrackAxeItem extends AxeItem {
		public NetherrackAxeItem(ToolMaterial material) {
			super(material, 7, -3.2F, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class NetherrackShovelItem extends ShovelItem {
		public NetherrackShovelItem(ToolMaterial material) {
			super(material, 2, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class NetherrackHoeItem extends HoeItem {
		public NetherrackHoeItem(ToolMaterial material) {
			super(material, 0, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
}
