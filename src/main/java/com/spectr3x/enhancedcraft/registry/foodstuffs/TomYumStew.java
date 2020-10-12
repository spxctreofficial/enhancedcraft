package com.spectr3x.enhancedcraft.registry.foodstuffs;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class TomYumStew extends Item {

    public TomYumStew() {
        super(new Item.Settings().group(ItemGroup.FOOD).maxCount(1).rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(20).saturationModifier(50f).statusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 3, 2)), 1f).build()));
    }
    
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        return user instanceof PlayerEntity && ((PlayerEntity)user).abilities.creativeMode ? itemStack : new ItemStack(Items.BOWL);
     }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
