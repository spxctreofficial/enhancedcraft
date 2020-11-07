package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AlloyShovelItem extends ShovelItem {

	public AlloyShovelItem(ToolMaterial material) {
		super(material, 4, -3f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
