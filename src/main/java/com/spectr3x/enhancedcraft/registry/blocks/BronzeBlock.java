package com.spectr3x.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

public class BronzeBlock extends Block {

	public static Material BronzeBlockMaterial = new FabricMaterialBuilder(MaterialColor.IRON).build();

	public BronzeBlock() {
		super(FabricBlockSettings.of(BronzeBlockMaterial).strength(5f, 6f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	}
}
