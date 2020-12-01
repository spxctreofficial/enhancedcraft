package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class BronzeShovelItem extends ShovelItem {

	public BronzeShovelItem(ToolMaterial material) {
		super(material, 2, -2.9f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
