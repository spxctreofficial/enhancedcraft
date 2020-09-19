package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class BronzeHoeItem extends HoeItem {

	public BronzeHoeItem(ToolMaterial material) {
		super(material, 0, -1.5f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
