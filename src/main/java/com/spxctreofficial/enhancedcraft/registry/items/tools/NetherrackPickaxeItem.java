package com.spxctreofficial.enhancedcraft.registry.items.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class NetherrackPickaxeItem extends PickaxeItem {

	public NetherrackPickaxeItem(ToolMaterial material) {
		super(material, 1, -2.8f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
