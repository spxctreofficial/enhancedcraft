package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class NetherrackHoeItem extends HoeItem {

	public NetherrackHoeItem(ToolMaterial material) {
		super(material, 0, -3f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
