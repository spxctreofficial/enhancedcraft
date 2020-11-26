package com.spxctreofficial.enhancedcraft.mixin;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
import com.spxctreofficial.enhancedcraft.registry.ECRegistry;
import com.spxctreofficial.enhancedcraft.registry.entity.EtheriumEntityData;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ECLivingEntity {

	// Etherium Variables

	private short etheriumLastBreathCooldown = 20 * 30;
	private short etheriumSetWearingTime = 0;

	private short etheriumEnrageStatus = 0;
	private short etheriumEnrageTime = 0;

	private boolean isEtheriumEnrageMaxed = false;

	private static final UUID ETHERIUM_HEALTH_BOOST_UUID = UUID.randomUUID();

	// Aecoron Variables

	private short aecoronRiptideSwimSpeedBonus = 0;
	private static final short AECORON_RIPTIDE_MAX_SWIM_BONUS = 20 * 5;

	private short aecoronSetWearingTime = 0;

	private short aecoronTimeToHeal = 0;
	private static final short AECORON_TIME_TO_HEAL_MAX = 20  * 37;
	private Vec3d aecoronStartPos;

	// Shadows

	@Shadow public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

	// @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

	@Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

	@Shadow public abstract float getHealth();

	@Shadow protected int riptideTicks;

	// Mixin Methods

	@Shadow public abstract ItemStack getStackInHand(Hand hand);

	@Shadow public abstract ItemStack getMainHandStack();

	@Shadow protected abstract void attackLivingEntity(LivingEntity target);

	@Shadow protected abstract void setLivingFlag(int mask, boolean value);

	@Inject(method = "onDeath", at = @At("RETURN"))
	public void onDeath(DamageSource source, CallbackInfo info) {
		etheriumEnrageInitiate(source);
	}

	@Inject(method = "applyDamage", at = @At("HEAD"))
	private void addEntityData(DamageSource source, float amount, CallbackInfo info) {
		applyEtheriumEntityData(source);
		extendFireDuration(source);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo info) {
		etheriumSetBonus();
		aecoronSetBonus();
	}

	@Inject(method = "tickRiptide", at = @At("HEAD"), cancellable = true)
	private void tickRiptide(Box a, Box b, CallbackInfo info) {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			Box box = a.union(b);
			List<Entity> list = this.world.getOtherEntities(this, box);
			if (!list.isEmpty()) {
				for (Entity entity : list) {
					if (entity instanceof LivingEntity) {
						this.addStatusEffect((new StatusEffectInstance(StatusEffects.STRENGTH, 2, 1, true, false)));
						this.riptideTicks = 0;
						this.attackLivingEntity((LivingEntity) entity);
						this.setVelocity(this.getVelocity().multiply(-0.2D));
						break;
					}
				}
			} else if (this.horizontalCollision) {
				this.riptideTicks = 0;
			}

			if (!this.world.isClient && this.riptideTicks <= 0) {
				this.setLivingFlag(4, false);
			}
			info.cancel();
		}
	}

	@ModifyVariable(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V", ordinal = 0), ordinal = 0)
	private float updateSwimSpeed(float j) {
		return aecoronSwimSpeedBonus(j);
	}

	// Private voids to clean up the code

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
					this.getEntityWorld().playSoundFromEntity(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this, // The position of where the sound will come from
							ECRegistry.ETHERIUM_ENRAGED_ENDED_SOUND_EVENT, // The sound that will play
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

				this.getEntityWorld().playSoundFromEntity(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						this, // The position of where the sound will come from
						ECRegistry.ETHERIUM_BONUS_ACTIVATED_SOUND_EVENT, // The sound that will play
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

					this.getEntityWorld().playSoundFromEntity(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							this, // The position of where the sound will come from
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
	private void applyEtheriumEntityData(DamageSource source) {
		if (source.getAttacker() == null || !(source.getAttacker() instanceof ECLivingEntity)) return;
		EtheriumEntityData a = new EtheriumEntityData((ECLivingEntity) source.getAttacker(), this);
	}

	private void aecoronSetBonus() {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {

			this.addStatusEffect((new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2, 0, true, false)));

			if (aecoronSetWearingTime < 3) {
				aecoronSetWearingTime++;
			}
			if (aecoronSetWearingTime == 1) {
				this.getEntityWorld().playSoundFromEntity(
						null, // Player - if non-null, will play sound for every nearby player *except* the specified player
						this, // The position of where the sound will come from
						ECRegistry.AECORON_SIREN_SOUND_EVENT, // The sound that will play
						SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
						0.45f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
						1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
				);
			}

			if (this.riptideTicks != 0) {
				if (this.riptideTicks == 1) {
					aecoronRiptideSwimSpeedBonus = AECORON_RIPTIDE_MAX_SWIM_BONUS;
				}
				this.fallDistance = 0.00000001F;
				this.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 4)));
			}
			if (this.aecoronRiptideSwimSpeedBonus != 0) {
				aecoronRiptideSwimSpeedBonus--;
			}

			if (this.getMainHandStack().isItemEqual(new ItemStack(Items.TRIDENT))) {

				this.addStatusEffect((new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, true, false)));

				if (this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1, this.getZ())).getBlock().is(Blocks.STONE_BRICKS) && this.isSubmergedInWater() && this.getAsEntity() instanceof PlayerEntity) {
					aecoronTimeToHeal++;
					System.out.println(aecoronTimeToHeal);

					if (aecoronTimeToHeal >= 20 * 5 && aecoronTimeToHeal < AECORON_TIME_TO_HEAL_MAX) {

						PlayerEntity playerEntity = (PlayerEntity) this.getAsEntity();

						if (aecoronTimeToHeal == 20 * 5) {
							world.playSoundFromEntity(null, this, ECRegistry.AECORON_SIRENS_CALL_SOUND_EVENT, SoundCategory.HOSTILE, 1f, 1f);
							aecoronStartPos = new Vec3d(this.getX(), this.getY(), this.getZ());
						}

						playerEntity.heal(1.0F / 15.0F);
						playerEntity.getHungerManager().add(1, 1.0F / 15F);
						playerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 4)));

						playerEntity.setVelocity(new Vec3d(0, 0, 0));

						if (!this.getPos().equals(aecoronStartPos)) {
							playerEntity.teleport(aecoronStartPos.getX(), aecoronStartPos.getY(), aecoronStartPos.getZ());
						}
					}
					else if (aecoronTimeToHeal == AECORON_TIME_TO_HEAL_MAX) {
						aecoronStartPos = null;
						aecoronTimeToHeal = -(20 * 300);

						this.addStatusEffect((new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 300, 0, true, false)));
						this.addStatusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 300, 9, true, false)));
						this.addStatusEffect((new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 300, 0, true, false)));
						this.addStatusEffect((new StatusEffectInstance(StatusEffects.SPEED, 20 * 300, 0, true, false)));
					}
				}
			}
			else {
				aecoronTimeToHeal = 0;
			}
			if (this.aecoronTimeToHeal < 0) {
				aecoronTimeToHeal++;
				System.out.println("Yes:" + aecoronTimeToHeal);
			}
		}
		else {
			aecoronSetWearingTime = 0;
			aecoronRiptideSwimSpeedBonus = 0;
		}
	}
	private float aecoronSwimSpeedBonus(float swimVelocity) {
		int armorCount = 0;
		for (ItemStack armorItem : getArmorItems()) {
			if (armorItem.isEmpty()) {
				break;
			}
			if (armorItem.getItem().isIn(ECRegistry.AECORON_ARMOR)) {
				armorCount++;
			}
		}
		if (armorCount == 4) {
			if (this.isSprinting()) {
				if (this.aecoronRiptideSwimSpeedBonus != 0) {
					return 0.9825F;
				}
				else {
					return 0.975F;
				}
			}
			else {
				if (this.aecoronRiptideSwimSpeedBonus != 0) {
					return 0.91F;
				}
				else {
					return 0.88F;
				}
			}
		}
		else {
			return swimVelocity;
		}
	}

	private void extendFireDuration(DamageSource source) {
		if (source.getAttacker() != null) {
			Entity attacker = source.getAttacker();

			for (ItemStack mainHandItem : attacker.getItemsHand()) {
				if (mainHandItem.isEmpty()) {
					continue;
				}
				if (mainHandItem.getItem().isIn(ECRegistry.EXTENDS_FIRE_DURATION) && this.isOnFire() && !this.isFireImmune()) {
					this.setOnFireFor(getFireTicks() + (getFireTicks() / 2));
				}
			}
		}
	}

	// ECLivingEntity

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

	// Useless Constructor

	@SuppressWarnings("ALL")
	private LivingEntityMixin(LivingEntity attacker) {
		super(null, null);
	}
}
