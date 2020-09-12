package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class EtheriumShovelItem extends ShovelItem {

	public EtheriumShovelItem(ToolMaterial material) {
		super(material, 8, -2.7f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
