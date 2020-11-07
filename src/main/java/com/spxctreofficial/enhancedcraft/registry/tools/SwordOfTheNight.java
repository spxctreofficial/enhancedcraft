package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordOfTheNight extends SwordItem {

    public SwordOfTheNight(ToolMaterial toolMaterial) {
        super(toolMaterial
        , 5 // the attackDamage
        , -2.4f // attackSpeed. Hand speed (4f) - attackSpeed = Final attack speed. for example swords are -2.4f because 4 - 2.4f = 1.6, which is the attack speed in-game under the tooltips
        , new Item.Settings().group(ItemGroup.COMBAT)); // Additional settings.
        // Your code doesn't need to be like mine. This is just for the convenience of comments.

        // If vscode or IntelliJ throws you an error, see if it's an import error in the console or problem section.
    }
    
}
