package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ZombieEntity.class)
public abstract class BetterZombiesMixin extends HostileEntity {

	Random rand = new Random();

	@Inject(method = "initEquipment", at = @At(value = "HEAD"), cancellable = true)
	private void changeEquipment(LocalDifficulty difficulty, CallbackInfo info) {
		super.initEquipment(difficulty);
		float hardModeWeaponChance = rand.nextFloat();
		if (this.world.getDifficulty() == Difficulty.HARD) {
			if (hardModeWeaponChance >= 0.75F) {
				hardClasses();
			}
			else {
				normalClasses();
			}
		}
		else if (rand.nextFloat() > (this.world.getDifficulty() == Difficulty.NORMAL ? 0.50F : 0.01F)) {
			normalClasses();
		}
		info.cancel();
	}
	private void normalClasses() {
		switch (rand.nextInt(10)) {
			case 0:
				// Generic Sword Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
				break;
			case 1:
				// Generic Shovel Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
				break;
			case 2:
				// Simple Sword Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ECRegistry.BRONZE_SWORD));
				break;
			case 3:
				// Simple Axe Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ECRegistry.BRONZE_AXE));
				break;
			case 4:
				// Generic Axe Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
				break;
			case 5:
				// Warrior Zombie
				this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_CHESTPLATE));
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
				break;
			case 6:
				// Strong Sword Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ECRegistry.ALLOY_SWORD));
				break;
			case 7:
				// Weak Sword Zombie
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			case 8:
				// Weak Warrior Zombie
				this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
				break;
			case 9:
				// Nitwit Zombie
				this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(ECRegistry.METAL_ALLOY));
				break;
		}
	}
	private void hardClasses() {
		switch (rand.nextInt(4)) {
			case 0:
				// Tank Zombie
				ItemStack enchantedDiamondSword = new ItemStack(Items.DIAMOND_SWORD);
				enchantedDiamondSword.addEnchantment(Enchantments.SHARPNESS, rand.nextInt(3) + 1);
				ItemStack unbreakingShield = new ItemStack(Items.SHIELD);
				unbreakingShield.addEnchantment(Enchantments.UNBREAKING, 3);

				this.equipStack(EquipmentSlot.MAINHAND, enchantedDiamondSword);
				this.equipStack(EquipmentSlot.OFFHAND, unbreakingShield);

				this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
				this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
				this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
				this.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 999999, 0)));

				this.updateDropChancesV2(EquipmentSlot.MAINHAND);
				this.updateDropChancesV2(EquipmentSlot.OFFHAND);

				this.updateDropChancesV2(EquipmentSlot.CHEST);
				this.updateDropChancesV2(EquipmentSlot.LEGS);
				this.updateDropChancesV2(EquipmentSlot.FEET);
				break;
			case 1:
				// Berserker Zombie
				ItemStack enchantedIronAxe = new ItemStack(Items.IRON_AXE);
				enchantedIronAxe.addEnchantment(Enchantments.SHARPNESS, 5);

				this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
				this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));

				this.equipStack(EquipmentSlot.MAINHAND, enchantedIronAxe);

				this.updateDropChancesV2(EquipmentSlot.HEAD);
				this.updateDropChancesV2(EquipmentSlot.CHEST);

				this.updateDropChancesV2(EquipmentSlot.MAINHAND);
				break;
			case 2:
				// Scout Zombie
				this.addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 999999, 3)));
				this.setCanPickUpLoot(true);
				break;
			case 3:
				// Furious Zombie
				ItemStack OPNetheriteSword = new ItemStack(Items.NETHERITE_SWORD);
				OPNetheriteSword.addEnchantment(Enchantments.SHARPNESS, 4);

				this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));

				this.equipStack(EquipmentSlot.MAINHAND, OPNetheriteSword);
				this.addStatusEffect((new StatusEffectInstance(StatusEffects.STRENGTH, 999999, 2)));

				this.updateDropChancesV2(EquipmentSlot.CHEST);

				this.updateDropChancesV2(EquipmentSlot.MAINHAND);
				break;
		}
	}

	private void updateDropChancesV2(EquipmentSlot slot) {
		float f = 0.025f;
		switch (slot.getType()) {
			case HAND:
				this.handDropChances[slot.getEntitySlotId()] = f;
				break;
			case ARMOR:
				this.armorDropChances[slot.getEntitySlotId()] = f;
				break;
		}
	}

	@SuppressWarnings("ALL")
	private BetterZombiesMixin() {
		super(null, null);
	}
}
