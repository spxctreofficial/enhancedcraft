package com.spxctreofficial.enhancedcraft.registry.misc;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
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

public class Yeay extends Item {
	public Yeay() {
		super(new Settings().group(ItemGroup.MISC).maxCount(1));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);

		world.playSoundFromEntity(null, user, ECRegistry.YEAY_SOUND_EVENT, SoundCategory.PLAYERS, 5f, 1f);
		user.getItemCooldownManager().set(this, (int) ((20 * 60) * 2.5F));
		user.incrementStat(Stats.USED.getOrCreateStat(this));

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
