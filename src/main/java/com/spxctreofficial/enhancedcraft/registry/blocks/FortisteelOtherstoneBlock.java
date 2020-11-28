package com.spxctreofficial.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.OreBlock;

public class FortisteelOtherstoneBlock extends OreBlock {

	public static Material fortisteelOtherstoneMaterial = new FabricMaterialBuilder(MaterialColor.STONE).build();

	public FortisteelOtherstoneBlock() {
		super(FabricBlockSettings.of(fortisteelOtherstoneMaterial).strength(3f, 3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	}
}
