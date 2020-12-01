package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class ObsidianAxeItem extends AxeItem {

	public ObsidianAxeItem(ToolMaterial material) {
		super(material, 9, -3.2f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
	}
    
}
