package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class ObsidianSwordItem extends SwordItem {

	public ObsidianSwordItem(ToolMaterial material) {
		super(material, 6, -2.65f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
	}
    
}
