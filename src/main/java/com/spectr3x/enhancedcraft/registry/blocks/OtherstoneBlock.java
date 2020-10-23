package com.spectr3x.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.OreBlock;

public class OtherstoneBlock extends OreBlock {

	public static Material OtherstoneBlockMaterial = new FabricMaterialBuilder(MaterialColor.STONE).build();

	public OtherstoneBlock() {
		super(FabricBlockSettings.of(OtherstoneBlockMaterial).strength(3f, 9f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	}
}
