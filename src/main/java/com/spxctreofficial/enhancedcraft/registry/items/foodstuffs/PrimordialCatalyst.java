package com.spxctreofficial.enhancedcraft.registry.items.foodstuffs;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class PrimordialCatalyst extends Item {

	public PrimordialCatalyst() {
		super(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(10).saturationModifier(21f).alwaysEdible()
				.statusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 3)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 420, 1)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 300, 5)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 420, 0)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.GLOWING, 20 * 420, 0)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 20, 1)), 1f)
				.statusEffect((new StatusEffectInstance(StatusEffects.SPEED, 20 * 20, 3)), 1f).build()));
    }
    
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    
}