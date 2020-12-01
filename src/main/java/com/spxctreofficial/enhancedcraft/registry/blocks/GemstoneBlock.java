package com.spxctreofficial.enhancedcraft.registry.blocks;

import java.util.Random;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class GemstoneBlock extends OreBlock {

	public static final Material gemstoneBlockMaterial = new FabricMaterialBuilder(MaterialColor.STONE).build();

	public GemstoneBlock() {
		super(FabricBlockSettings.of(gemstoneBlockMaterial).strength(5f, 9f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	}

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
		if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
		   int i = this.experienceDropped(world.random);
		   if (i > 0) {
			  this.dropExperience(world, pos, i);
		   }
		}
	 }

	 protected int experienceDropped(Random random) {
		return MathHelper.nextInt(random,9, 16);
	}
}
