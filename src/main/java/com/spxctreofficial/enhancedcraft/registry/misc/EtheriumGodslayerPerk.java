package com.spxctreofficial.enhancedcraft.registry.misc;

import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class EtheriumGodslayerPerk extends Item {
	public EtheriumGodslayerPerk() {
		super(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.EPIC));
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		ItemStack itemStack = user.getStackInHand(hand);

		int armorCount = 0;
		for (ItemStack armorItem : user.getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.ETHERIUM_ARMOR)) {
				armorCount++;
			}
		}

		if (armorCount == 4) {

			ECLivingEntity ecLivingEntity = (ECLivingEntity) user;

			ecLivingEntity.setEtheriumEnrageStatus((short) 3);
			ecLivingEntity.setEtheriumEnrageTime((short) (20 * 5));
			ecLivingEntity.setIsEtheriumEnrageMaxed(true);

			world.playSoundFromEntity(
					null, // Player - if non-null, will play sound for every nearby player *except* the specified player
					user, // The position of where the sound will come from
					ECRegistry.ETHERIUM_ENRAGED_SOUND_EVENT, // The sound that will play
					SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
					1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
					1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
			);
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20 * 5, 0));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 5, 1));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 1));
			user.getItemCooldownManager().set(this, 20 * 45);
			return TypedActionResult.success(itemStack, world.isClient());

		}

		return TypedActionResult.fail(itemStack);

	}

	public boolean hasGlint(ItemStack itemStack) {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(new TranslatableText("item.enhancedcraft.etherium_godslayer_perk.tooltip"));
	}
}
