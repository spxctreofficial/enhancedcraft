package com.spxctreofficial.enhancedcraft.registry.items.misc;

import com.spxctreofficial.enhancedcraft.registry.entity.SmartPearlEntity;
import com.spxctreofficial.enhancedcraft.registry.sounds.ECSoundRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SmartPearlItem extends Item {
	public SmartPearlItem() {
		super(new Item.Settings().group(ItemGroup.COMBAT).rarity(Rarity.RARE).maxCount(16));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), ECSoundRegistry.SMART_PEARL_THROW_SOUND_EVENT, SoundCategory.NEUTRAL, 0.5F, 1F);
		user.getItemCooldownManager().set(this, 5);
		if (!world.isClient) {
			SmartPearlEntity pearlEntity = new SmartPearlEntity(world, user);
			pearlEntity.setItem(itemStack);
			pearlEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
			world.spawnEntity(pearlEntity);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
