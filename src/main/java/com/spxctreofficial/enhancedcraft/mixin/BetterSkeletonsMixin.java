package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(AbstractSkeletonEntity.class)
public abstract class BetterSkeletonsMixin extends HostileEntity {

	@Shadow public abstract void equipStack(EquipmentSlot slot, ItemStack stack);

	Random rand = new Random();

	@Inject(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/AbstractSkeletonEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"), cancellable = true)
	private void changeEquipment(LocalDifficulty difficulty, CallbackInfo info) {
		int itemChance = rand.nextInt(8);
		switch (itemChance) {
			case 0:
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ECRegistry.ALLOY_SWORD));
				break;
			case 1:
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
				break;
			case 2:
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
				break;
			default:
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		}
		info.cancel();
	}

	@SuppressWarnings("ALL")
	private BetterSkeletonsMixin() {
		super(null, null);
	}
}
