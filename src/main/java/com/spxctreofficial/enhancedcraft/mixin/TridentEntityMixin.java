package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.registry.tags.ECTagRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(TridentEntity.class)
public class TridentEntityMixin {

	@ModifyVariable(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/TridentEntity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V", ordinal = 0), index = 4, ordinal = 0)
	private double updateLoyaltyReturnTime(double d) {
		Entity owner = this.getAsTridentEntity().getOwner();

		assert owner != null;
		return aecoronLoyaltyBonus(owner, d);
	}

	@ModifyVariable(method = "onEntityHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/TridentEntity;getOwner()Lnet/minecraft/entity/Entity;", ordinal = 0), index = 3, ordinal = 0)
	private float updateTridentDamage(float f) {
		Entity owner = this.getAsTridentEntity().getOwner();

		int armorCount = 0;
		assert owner != null;
		for (ItemStack armorItem : owner.getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECTagRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}

		if (armorCount == 4) {
			return 14;
		}
		else {
			return f;
		}
	}

	private double aecoronLoyaltyBonus(Entity owner, double loyaltyReturnTime) {
		int armorCount = 0;
		for (ItemStack armorItem : owner.getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECTagRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			return loyaltyReturnTime * 3;
		}
		else {
			return loyaltyReturnTime;
		}
	}

	private TridentEntity getAsTridentEntity() {
		return (TridentEntity) (Object) this;
	}
}
