package com.spectr3x.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

public class EtheriumBlock extends Block {

	public static Material EtheriumBlockMaterial = new FabricMaterialBuilder(MaterialColor.DIAMOND).build();  

	public EtheriumBlock() {
		super(FabricBlockSettings.of(EtheriumBlockMaterial).strength(25f, 1200f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	}
}
