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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GayFireballItem extends Item {
	public GayFireballItem() {
		super(new Settings().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON).maxCount(1));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 3.5F, 1F);

		spawnBarrage(world, user, hand);

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}

	public void spawnBarrage(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (!world.isClient) {
			Vec3d vector = user.getRotationVector();
			FireballEntity fireballEntity = new FireballEntity(user.world, user.getX(), user.getEyeY(), user.getZ(), vector.x, vector.y, vector.z);
			fireballEntity.setItem(itemStack);
			fireballEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 0.75F, 10F);
			for (int i = 0; i < 10; i++) {
				user.world.spawnEntity(fireballEntity);
			}
		}
	}
}
