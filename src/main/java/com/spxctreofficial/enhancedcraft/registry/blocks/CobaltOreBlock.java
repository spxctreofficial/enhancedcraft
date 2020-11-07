package com.spxctreofficial.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.OreBlock;

public class CobaltOreBlock extends OreBlock {

	public static Material CobaltOreMaterial = new FabricMaterialBuilder(MaterialColor.STONE).build();

	public CobaltOreBlock() {
		super(FabricBlockSettings.of(CobaltOreMaterial).strength(3f, 3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	}
}
