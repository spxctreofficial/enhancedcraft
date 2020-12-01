package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ObsidianPickaxeItem extends PickaxeItem {

	public ObsidianPickaxeItem(ToolMaterial material) {
		super(material, 5, -3f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
	}
    
}
