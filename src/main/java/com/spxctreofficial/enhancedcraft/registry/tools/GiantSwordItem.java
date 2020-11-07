package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class GiantSwordItem extends SwordItem {

	public GiantSwordItem(ToolMaterial toolMaterial) {
		super(toolMaterial, 4, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
	}
    
}
