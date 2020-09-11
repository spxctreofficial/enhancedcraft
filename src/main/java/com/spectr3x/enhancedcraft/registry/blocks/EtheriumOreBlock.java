package com.spectr3x.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.minecraft.block.OreBlock;

public class EtheriumOreBlock extends OreBlock {

	public static Material EtheriumOreMaterial = new FabricMaterialBuilder(MaterialColor.STONE).build();  

	public EtheriumOreBlock() {
		super(FabricBlockSettings.of(EtheriumOreMaterial).hardness(25f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).resistance(1200f).lightLevel(3).requiresTool());
	}
    
}
