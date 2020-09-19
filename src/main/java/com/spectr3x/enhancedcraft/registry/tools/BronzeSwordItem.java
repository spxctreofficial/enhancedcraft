package com.spectr3x.enhancedcraft.registry.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class BronzeSwordItem extends SwordItem {

	public BronzeSwordItem(ToolMaterial material) {
		super(material, 4, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
	}
    
}
