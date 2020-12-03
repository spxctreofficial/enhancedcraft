package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class PurigoldTools {

	// Tool Materials
	public static class PurigoldToolMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 172;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 12F;
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
			return 22;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ECItemRegistry.COBALT_INGOT);
		}
	}
	public static class PurigoldToolAlternateMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 172;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 12F;
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
			return 22;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ECItemRegistry.COBALT_INGOT);
		}
	}

	// Tools
	public static class PurigoldSwordItem extends SwordItem {
		public PurigoldSwordItem(ToolMaterial material) {
			super(material, 6, -2.4f, new Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class PurigoldPickaxeItem extends PickaxeItem {
		public PurigoldPickaxeItem(ToolMaterial material) {
			super(material, 3, -2.8f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class PurigoldAxeItem extends AxeItem {
		public PurigoldAxeItem(ToolMaterial material) {
			super(material, 8, -2.9f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class PurigoldShovelItem extends ShovelItem {
		public PurigoldShovelItem(ToolMaterial material) {
			super(material, 3, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class PurigoldHoeItem extends HoeItem {
		public PurigoldHoeItem(ToolMaterial material) {
			super(material, 0, -1f, new Settings().group(ItemGroup.TOOLS));
		}
	}
}
