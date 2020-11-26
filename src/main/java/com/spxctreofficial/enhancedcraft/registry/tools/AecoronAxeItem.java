package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AecoronAxeItem extends AxeItem {

	public AecoronAxeItem(ToolMaterial material) {
		super(material, 8, -3F, new Settings().group(ItemGroup.TOOLS));
	}
    
}
