package com.spxctreofficial.enhancedcraft.registry.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FireballItem extends Item {
	public FireballItem() {
		super(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON).maxCount(3));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 0.5F, 1F);
		if (!world.isClient) {
			FireballEntity fireballEntity = new FireballEntity(world, user.getX(), user.getY() + 1, user.getZ(), 0F, 0F, 0F);
			fireballEntity.setItem(itemStack);
			fireballEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.0F, 0F);
			world.spawnEntity(fireballEntity);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.method_29237(itemStack, world.isClient());
	}
}
