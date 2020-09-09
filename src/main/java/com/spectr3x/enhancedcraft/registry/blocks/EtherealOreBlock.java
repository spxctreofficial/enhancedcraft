package com.spectr3x.enhancedcraft.registry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;

public class EtherealOreBlock extends OreBlock {

	public EtherealOreBlock() {
		super(FabricBlockSettings.of(Material.METAL).hardness(25f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3));
	}
    
}
