package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AlloyAxeItem extends AxeItem {

	public AlloyAxeItem(ToolMaterial material) {
		super(material, 8, -3.05f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
