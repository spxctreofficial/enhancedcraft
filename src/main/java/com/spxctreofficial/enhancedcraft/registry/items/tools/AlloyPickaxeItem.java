package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AlloyPickaxeItem extends PickaxeItem {

	public AlloyPickaxeItem(ToolMaterial material) {
		super(material, 3, -2.4f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
