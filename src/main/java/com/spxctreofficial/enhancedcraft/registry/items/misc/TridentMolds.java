package com.spxctreofficial.enhancedcraft.registry.items.misc;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class TridentMolds {

	public static class TridentMoldDamaged extends Item {
		public TridentMoldDamaged() {
			super(new Settings().group(ItemGroup.MISC).maxCount(1).recipeRemainder(ECItemRegistry.SHATTERED_TRIDENT_MOLD));
		}

		@Override
		public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
			tooltip.add(new TranslatableText("item.enhancedcraft.trident_mold_damaged.tooltip"));
		}
	}

	public static class TridentMoldShattered extends Item {
		public TridentMoldShattered() {
			super(new Settings().group(ItemGroup.MISC).maxCount(1));
		}

		@Override
		public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
			tooltip.add(new TranslatableText("item.enhancedcraft.trident_mold_shattered.tooltip"));
		}
	}

	public static class TridentMold extends Item {
		public TridentMold() {
			super(new Settings().group(ItemGroup.MISC).maxCount(1).recipeRemainder(ECItemRegistry.DAMAGED_TRIDENT_MOLD));
		}

		@Override
		public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
			tooltip.add(new TranslatableText("item.enhancedcraft.trident_mold.tooltip"));
		}
	}
}


