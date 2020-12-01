package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class EtheriumHoeItem extends HoeItem {

	public EtheriumHoeItem(ToolMaterial material) {
		super(material, 2, 0f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
