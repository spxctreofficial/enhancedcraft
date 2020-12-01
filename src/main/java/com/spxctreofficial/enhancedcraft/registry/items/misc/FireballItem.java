package com.spxctreofficial.enhancedcraft.registry.items.misc;

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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballItem extends Item {
	public FireballItem() {
		super(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON).maxCount(3));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 0.5F, 1F);

		spawnFireball(world, user, hand);

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}

	public void spawnFireball(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (!world.isClient) {
			Vec3d vector = user.getRotationVector();
			FireballEntity fireballEntity = new FireballEntity(user.world, user, vector.x, vector.y, vector.z);
			fireballEntity.setItem(itemStack);
			fireballEntity.updatePosition(user.getX(), user.getEyeY(), user.getZ());
			fireballEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
			user.world.spawnEntity(fireballEntity);
		}
	}
}
