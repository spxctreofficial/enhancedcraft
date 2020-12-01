package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AlloyHoeItem extends HoeItem {

	public AlloyHoeItem(ToolMaterial material) {
		super(material, 0, -0.5f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
