package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class EtheriumSwordItem extends SwordItem {

	public EtheriumSwordItem(ToolMaterial material) {
		super(material, 13, -2.2f, new Item.Settings().group(ItemGroup.COMBAT));
	}
    
}
