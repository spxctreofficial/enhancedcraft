package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class CobaltTools {

	// Tool Materials
	public static class CobaltToolMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 650;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 8.25F;
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
			return 17;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ECItemRegistry.COBALT_INGOT);
		}
	}
	public static class CobaltToolAlternateMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 650;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 8.25F;
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
			return 17;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ECItemRegistry.COBALT_INGOT);
		}
	}

	// Tools
	public static class CobaltSwordItem extends SwordItem {
		public CobaltSwordItem(ToolMaterial material) {
			super(material, 6, -2.4f, new Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class CobaltPickaxeItem extends PickaxeItem {
		public CobaltPickaxeItem(ToolMaterial material) {
			super(material, 4, -2.8f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class CobaltAxeItem extends AxeItem {
		public CobaltAxeItem(ToolMaterial material) {
			super(material, 8, -2.95f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class CobaltShovelItem extends ShovelItem {
		public CobaltShovelItem(ToolMaterial material) {
			super(material, 5, -3f, new Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class CobaltHoeItem extends HoeItem {
		public CobaltHoeItem(ToolMaterial material) {
			super(material, 0, 0f, new Settings().group(ItemGroup.TOOLS));
		}
	}
}
