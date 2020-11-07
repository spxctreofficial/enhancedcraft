package com.spxctreofficial.enhancedcraft.registry.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SwordOfTheNightToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() { // Durability of the item. How many times an item can be used before it breaks. This has to be an int
        return 350; // This is 100 more than Iron.
    }

    @Override
    public float getMiningSpeedMultiplier() { // Mining speed multiplier of a tool. This affects how fast a pickaxe would be if it were to use this toolmaterial.
        return 6f; // This is the same as iron
    }

    @Override
    public float getAttackDamage() { // The base attack damage of any tool implementing this toolmaterial.
        return 0f; // This can be a float.
    }

    @Override
    public int getMiningLevel() { // Mining level determines what a pickaxe can mine. Wood 0, Stone 1, Iron 2, Diamond 3, Netherite 4.
        return 2; // I'm not making a pickaxe so this shouldn't matter.
    }

    @Override
    public int getEnchantability() { // Enchantability is how effective the Enchanting Table will be to this tool. Int only.
        return 14; // 14 is the enchantability of Iron.
    }

    @Override
    public Ingredient getRepairIngredient() { // Repair ingredient specifies what ingredient/item will be needed in order to repair the damn thing.
        return null; // Returning null means that you cannot use an ingredient to repair the item.
    }
    
}
