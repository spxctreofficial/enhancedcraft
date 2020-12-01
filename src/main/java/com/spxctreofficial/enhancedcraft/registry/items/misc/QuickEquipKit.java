package com.spxctreofficial.enhancedcraft.registry.items.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class QuickEquipKit extends Item {
	public QuickEquipKit() {
		super(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSoundFromEntity(null, user, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.NEUTRAL, 1f, 1f);

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		user.inventory.insertStack(new ItemStack(Items.CHAINMAIL_HELMET));
		user.inventory.insertStack(new ItemStack(Items.CHAINMAIL_CHESTPLATE));
		user.inventory.insertStack(new ItemStack(Items.CHAINMAIL_LEGGINGS));
		user.inventory.insertStack(new ItemStack(Items.CHAINMAIL_BOOTS));
		user.inventory.insertStack(new ItemStack(Items.IRON_SWORD));

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
