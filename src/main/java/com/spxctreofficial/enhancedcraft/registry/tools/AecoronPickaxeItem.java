package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AecoronPickaxeItem extends PickaxeItem {

	public AecoronPickaxeItem(ToolMaterial material) {
		super(material, 4, -2.8f, new Settings().group(ItemGroup.TOOLS));
	}
    
}
