package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import com.spxctreofficial.enhancedcraft.registry.entity.EtheriumEntityData;
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

	private short etheriumLastBreathCooldown = 20 * 30;
	private short etheriumSetWearingTime = 0;

	private short etheriumEnrageStatus = 0;
	private short etheriumEnrageTime = 0;

	private boolean isEtheriumEnrageMaxed = false;

	private static final UUID ETHERIUM_HEALTH_BOOST_UUID = UUID.randomUUID();

	@Shadow public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

	// @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

	@Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

	@Shadow public abstract float getHealth();

	@Inject(method = "onDeath", at = @At("RETURN"))
	public void onDeath(DamageSource source, CallbackInfo info) {
		etheriumEnrageInitiate(source);
	}

	@Inject(method = "applyDamage", at = @At("HEAD"))
	private void addEntityData(DamageSource source, float amount, CallbackInfo info) {
		if (source.getAttacker() == null || !(source.getAttacker() instanceof ECLivingEntity)) return;
		EtheriumEntityData a = new EtheriumEntityData((ECLivingEntity) source.getAttacker(), this);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo info) {
		etheriumSetBonus();
	}

	// Private voids to clean up the code

	private void etheriumEnrageInitiate(DamageSource source) {
		try {
			LivingEntity attacker = (LivingEntity) source.getAttacker();
			if (attacker == null) return;

			EtheriumEntityData.getData(attacker).etheriumEnrageMechanic();
		} catch (ClassCastException e) {
			EnhancedCraft.LOGGER.warn("An entity was not the correct type! Tell spxctreofficial to fuck himself " +
					"and fix his fucking code and tell him how much of a cunt meatball he is. Thank you for your continued"+
					"support. Stay safe and catch corona lol", e);
		}
	}

	private void etheriumSetBonus() {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.ETHERIUM_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			if (etheriumSetWearingTime < 3) {
				etheriumSetWearingTime++;
			}

			if (getEtheriumEnrageTime() > 0) {
				setEtheriumEnrageTime((short) (getEtheriumEnrageTime() - 1));
			}
			else {
				if (getIsEtheriumEnrageMaxed()) {
					this.getEntityWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this.getBlockPos(), // The position of where the sound will come from
							ECRegistry.etheriumEnragedEndedSoundEvent, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
					setIsEtheriumEnrageMaxed(false);
				}
				setEtheriumEnrageStatus((short) 0);
			}

			this.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 1, true, false)));
			if (etheriumSetWearingTime == 1) {
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(ETHERIUM_HEALTH_BOOST_UUID);
				getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(new EntityAttributeModifier(ETHERIUM_HEALTH_BOOST_UUID, "Etherium bonus", 20, EntityAttributeModifier.Operation.ADDITION));

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
				if (etheriumLastBreathCooldown <= 0) {
					etheriumLastBreathCooldown = 600;
				}

				if (etheriumLastBreathCooldown == 600) {
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
				etheriumLastBreathCooldown -= 1;
			}
			else {
				etheriumLastBreathCooldown = 600;
			}
		}
		else {
			getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(ETHERIUM_HEALTH_BOOST_UUID);
			etheriumSetWearingTime = 0;
		}
	}

	@Override
	public LivingEntity getAsEntity() {
		return (LivingEntity) (Object) this;
	}

	@Override
	public short getEtheriumEnrageStatus() {
		return this.etheriumEnrageStatus;
	}

	@Override
	public short getEtheriumEnrageTime() {
		return this.etheriumEnrageTime;
	}

	@Override
	public boolean getIsEtheriumEnrageMaxed() {
		return this.isEtheriumEnrageMaxed;
	}

	@Override
	public void setEtheriumEnrageStatus(short n) {
		this.etheriumEnrageStatus = n;
	}

	@Override
	public void setEtheriumEnrageTime(short n) {
		this.etheriumEnrageTime = n;
	}

	@Override
	public void setIsEtheriumEnrageMaxed(boolean bool) {
		this.isEtheriumEnrageMaxed = bool;
	}

	@SuppressWarnings("ALL")
	private LivingEntityMixin() {
		super(null, null);
	}
}
