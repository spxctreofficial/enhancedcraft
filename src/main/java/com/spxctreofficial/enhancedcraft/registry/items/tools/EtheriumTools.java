package com.spxctreofficial.enhancedcraft.registry.items.tools;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class EtheriumTools {

	// Tool Materials
	public static class EtheriumToolMaterial implements ToolMaterial {
		@Override
		public int getDurability() {
			return 1796;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 28f;
		}

		@Override
		public float getAttackDamage() {
			return 0f;
		}

		@Override
		public int getMiningLevel() {
			return 7;
		}

		@Override
		public int getEnchantability() {
			return 35;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(ECItemRegistry.ETHERIUM);
		}
	}

	// Tools
	public static class EtheriumSwordItem extends SwordItem {
		public EtheriumSwordItem(ToolMaterial material) {
			super(material, 13, -2.2f, new Item.Settings().group(ItemGroup.COMBAT));
		}
	}
	public static class EtheriumPickaxeItem extends PickaxeItem {
		public EtheriumPickaxeItem(ToolMaterial material) {
			super(material, 7, -2.4f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class EtheriumAxeItem extends AxeItem {
		public EtheriumAxeItem(ToolMaterial material) {
			super(material, 14, -2.9f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class EtheriumShovelItem extends ShovelItem {
		public EtheriumShovelItem(ToolMaterial material) {
			super(material, 8, -2.7f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
	public static class EtheriumHoeItem extends HoeItem {
		public EtheriumHoeItem(ToolMaterial material) {
			super(material, 2, 0f, new Item.Settings().group(ItemGroup.TOOLS));
		}
	}
}
