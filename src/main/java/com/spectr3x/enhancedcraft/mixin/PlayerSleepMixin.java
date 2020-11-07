package com.spectr3x.enhancedcraft.mixin;

import com.mojang.datafixers.util.Either;
import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.entity.HeroBrineEntity;
import com.spectr3x.enhancedcraft.registry.ModRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(PlayerEntity.class)
public class PlayerSleepMixin {
	PlayerEntity player = (PlayerEntity) (Object) this;

	@Inject(method = "trySleep(Lnet/minecraft/util/math/BlockPos;)Lcom/mojang/datafixers/util/Either;", at = @At(value = "HEAD"), cancellable = true)
	private void trySleep (BlockPos pos, CallbackInfoReturnable<Either<PlayerEntity.SleepFailureReason, Unit>> cir) {
		Random random = new Random();
		int chance = random.nextInt(100);
		ServerPlayerEntity ServerPlayer = (ServerPlayerEntity) player;
		EnhancedCraft.LOGGER.info("Server Player - Playing Sound");
		ServerPlayer.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0f, 1.0f);
		System.out.println(ServerPlayer);
		if (chance == 1) {
			ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20));
			ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20));
			ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20));

			// Spawm Haunted Herobrine
				/*HeroBrineEntity herobrine = new HeroBrineEntity(ModRegistry.HerobrineEntity, ServerPlayer.world);
				BlockPos playerPos = new BlockPos(ServerPlayer.getPos().add(ServerPlayer.getRotationVector().multiply(1)));
				System.out.println(playerPos);
				herobrine.setPos(playerPos.getX(), playerPos.getY() + 1, playerPos.getZ());
				System.out.println(ServerPlayer.world);
				ServerPlayer.world.spawnEntity(herobrine);
				System.out.println(herobrine);*/

			HeroBrineEntity witherSkeletonEntity = (HeroBrineEntity) ModRegistry.HerobrineEntity
					.create(ServerPlayer.world);
			BlockPos playerPos = new BlockPos(ServerPlayer.getPos());
			witherSkeletonEntity.refreshPositionAndAngles(playerPos, 0.0F, 0.0F);
			ServerPlayer.world.spawnEntity(witherSkeletonEntity);
			cir.cancel();
		}
	}
}
