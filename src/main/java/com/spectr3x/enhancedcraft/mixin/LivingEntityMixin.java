package com.spectr3x.enhancedcraft.mixin;

import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.entity.EtheriumEntityData;
import com.spectr3x.enhancedcraft.interfaces.ECLivingEntity;
import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ECLivingEntity {

	private short EtheriumLastBreathCooldown = 20 * 30;
	private short EtheriumSetWearingTime = 0;

	private short EtheriumEnrageStatus = 0;
	private short EtheriumEnrageTime = 0;

	private boolean IsEtheriumEnrageMaxed = false;

	private static final UUID EtheriumHealthBoostUUID = UUID.randomUUID();

	@Shadow public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

	// @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

	@Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

	@Shadow public abstract float getHealth();

	@Inject(method = "onDeath", at = @At("RETURN"))
	public void onDeath(DamageSource source, CallbackInfo info) {
		try {
			LivingEntity attacker = (LivingEntity) source.getAttacker();
			if (attacker == null) return;

			EtheriumEntityData.getData(attacker).EtheriumEnrageMechanic();
		} catch (ClassCastException e) {
			EnhancedCraft.LOGGER.warn("An entity was not the correct type! Tell spxctreofficial to fuck himself " +
					"and fix his fucking code and tell him how much of a cunt meatball he is. Thank you for your continued"+
					"support. Stay safe and catch corona lol", e);
		}
	}

	@Inject(method = "applyDamage", at = @At("HEAD"))
	private void addEntityData(DamageSource source, float amount, CallbackInfo info) {
		if (source.getAttacker() == null || !(source.getAttacker() instanceof ECLivingEntity)) return;
		EtheriumEntityData a = new EtheriumEntityData((ECLivingEntity) source.getAttacker(), this);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo info) {
		EtheriumSetBonus();
	}

	// Private voids to clean up the code

	private void EtheriumSetBonus() {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ModRegistry.EtheriumArmor)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			if (EtheriumSetWearingTime < 3) {
				EtheriumSetWearingTime++;
			}

			if (getEtheriumEnrageTime() > 0) {
				setEtheriumEnrageTime((short) (getEtheriumEnrageTime() - 1));
			}
			else {
				if (getIsEtheriumEnrageMaxed()) {
					this.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this.getBlockPos(), // The position of where the sound will come from
							ModRegistry.EtheriumEnragedEndedSoundEvent, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
					setIsEtheriumEnrageMaxed(false);
				}
				setEtheriumEnrageStatus((short) 0);
			}

			this.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
			if (EtheriumSetWearingTime == 1) {
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EtheriumHealthBoostUUID);
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(new EntityAttributeModifier(EtheriumHealthBoostUUID, "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));

				this.getEntityWorld().playSound(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						this.getBlockPos(), // The position of where the sound will come from
						SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, // The sound that will play
						SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						1.5f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
				);
			}

			if (getHealth() <= 4) {
				if (EtheriumLastBreathCooldown <= 0) {
					EtheriumLastBreathCooldown = 600;
				}

				if (EtheriumLastBreathCooldown == 600) {
					addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1)));
					addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 600, 2)));
					addStatusEffect((new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)));

					this.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this.getBlockPos(), // The position of where the sound will come from
							SoundEvents.ITEM_TRIDENT_RETURN, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1.25f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);

				}
				EtheriumLastBreathCooldown -= 1;
			}
			else {
				EtheriumLastBreathCooldown = 600;
			}
		}
		else {
			getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EtheriumHealthBoostUUID);
			EtheriumSetWearingTime = 0;
		}
	}

	@Override
	public LivingEntity getAsEntity() {
		return (LivingEntity) (Object) this;
	}

	@Override
	public short getEtheriumEnrageStatus() {
		return this.EtheriumEnrageStatus;
	}

	@Override
	public short getEtheriumEnrageTime() {
		return this.EtheriumEnrageTime;
	}

	@Override
	public boolean getIsEtheriumEnrageMaxed() {
		return this.IsEtheriumEnrageMaxed;
	}

	@Override
	public void setEtheriumEnrageStatus(short n) {
		this.EtheriumEnrageStatus = n;
	}

	@Override
	public void setEtheriumEnrageTime(short n) {
		this.EtheriumEnrageTime = n;
	}

	@Override
	public void setIsEtheriumEnrageMaxed(boolean bool) {
		this.IsEtheriumEnrageMaxed = bool;
	}

	@SuppressWarnings("ALL")
	private LivingEntityMixin() {
		super(null, null);
	}
}
