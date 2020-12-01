package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AecoronShovelItem extends ShovelItem {

	public AecoronShovelItem(ToolMaterial material) {
		super(material, 4, -3f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
