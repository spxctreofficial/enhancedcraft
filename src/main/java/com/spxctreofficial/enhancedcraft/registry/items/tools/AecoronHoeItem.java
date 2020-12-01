package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AecoronHoeItem extends HoeItem {

	public AecoronHoeItem(ToolMaterial material) {
		super(material, 0, 0f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
