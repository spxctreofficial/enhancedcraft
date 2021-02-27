package com.spxctreofficial.enhancedcraft.registry.items.misc;

import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class TestItem extends Item {
    public TestItem() {
        super(new Item.Settings().group(ItemGroup.MISC));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        final Random rand = new Random();

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1);
        }

        if (!world.isClient) {
            switch (rand.nextInt(3)) {
                case 0:
                    ItemStack someFuckingItem = new ItemStack(Items.ALLIUM);
                    someFuckingItem.setCount(rand.nextInt(3) + 1);
                    user.inventory.insertStack(someFuckingItem);
                    break;
                case 1:
                    user.inventory.insertStack(new ItemStack(Items.IRON_SWORD));
                    break;
                case 2:
                    user.inventory.insertStack(new ItemStack(ECItemRegistry.COBALT_INGOT));
                    break;
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
