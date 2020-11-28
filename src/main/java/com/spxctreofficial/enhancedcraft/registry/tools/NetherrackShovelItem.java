package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class NetherrackShovelItem extends ShovelItem {

	public NetherrackShovelItem(ToolMaterial material) {
		super(material, 2, -3f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
