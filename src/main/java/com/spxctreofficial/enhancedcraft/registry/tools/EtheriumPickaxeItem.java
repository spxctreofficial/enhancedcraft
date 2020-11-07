package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class EtheriumPickaxeItem extends PickaxeItem {

	public EtheriumPickaxeItem(ToolMaterial material) {
		super(material, 7, -2.4f, new Item.Settings().group(ItemGroup.TOOLS));
	}
    
}
