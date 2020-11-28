package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class NetherrackSwordItem extends SwordItem {

	public NetherrackSwordItem(ToolMaterial material) {
		super(material, 3, -2.4f, new Settings().group(ItemGroup.COMBAT));
	}
    
}
