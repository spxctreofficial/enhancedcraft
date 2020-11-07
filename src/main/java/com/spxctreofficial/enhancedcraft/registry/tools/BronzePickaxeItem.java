package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BronzePickaxeItem extends PickaxeItem {

	public BronzePickaxeItem(ToolMaterial material) {
		super(material, 2, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
