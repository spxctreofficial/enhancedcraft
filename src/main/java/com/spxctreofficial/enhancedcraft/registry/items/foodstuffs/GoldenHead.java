package com.spxctreofficial.enhancedcraft.registry.items.foodstuffs;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
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

public class GoldenHead extends Item {

	public GoldenHead() {
		super(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.RARE));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		// Gets the ItemStack in-hand of user
		ItemStack itemStack = user.getStackInHand(hand);
		// Sets a reuse-delay
		user.getItemCooldownManager().set(this, 20 * 3);
		// Plays a eating sound
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 1F, 1F);

		// Effects
		user.getHungerManager().add(4, 9.6F); // gives 4 hunger points and 9.6 saturation points (identical to Golden Apple)
		user.addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 120, 0)));
		user.addStatusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 5, 1)));

		// Decrement ItemStack
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.abilities.creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
