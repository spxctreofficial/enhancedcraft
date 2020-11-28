package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class NetherrackAxeItem extends AxeItem {

	public NetherrackAxeItem(ToolMaterial material) {
		super(material, 7, -3.2F, new Settings().group(ItemGroup.TOOLS));
	}
    
}
