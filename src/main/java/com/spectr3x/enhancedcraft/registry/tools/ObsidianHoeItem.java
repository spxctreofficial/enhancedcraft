package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class ObsidianHoeItem extends HoeItem {

	public ObsidianHoeItem(ToolMaterial material) {
		super(material, 1, -1.2f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
	}
    
}
