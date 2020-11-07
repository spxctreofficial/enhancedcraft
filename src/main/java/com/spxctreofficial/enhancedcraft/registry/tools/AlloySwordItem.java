package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AlloySwordItem extends SwordItem {

	public AlloySwordItem(ToolMaterial material) {
		super(material, 5, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
	}
    
}
