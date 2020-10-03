package com.spectr3x.enhancedcraft.mixin;

import com.mojang.datafixers.util.Either;
import com.spectr3x.enhancedcraft.EnhancedCraft;
import com.spectr3x.enhancedcraft.entity.HeroBrineEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
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
		int i = random.nextInt(2);
		if (player.world.isClient()) {
			ClientPlayerEntity ClientPlayer = (ClientPlayerEntity) player;
			EnhancedCraft.logger.info("Client Player - Playing Sound");
			ClientPlayer.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0f, 1.0f);
			if (i == 1) {
				ClientPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20));
				ClientPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20));
				ClientPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20));

				// Spawm Haunted Herobrine
				HeroBrineEntity herobrine = new HeroBrineEntity(EnhancedCraft.HEROBRINE, ClientPlayer.world);
				ClientPlayer.world.spawnEntity(herobrine);
				BlockPos playerPos = new BlockPos(ClientPlayer.getPos().add(ClientPlayer.getRotationVector().multiply(1)));
				herobrine.setPos(playerPos.getX(), playerPos.getY(), playerPos.getZ());

				cir.cancel();
			}
		} else {
			ServerPlayerEntity ServerPlayer = (ServerPlayerEntity) player;
			EnhancedCraft.logger.info("Server Player - Playing Sound");
			ServerPlayer.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0f, 1.0f);
			System.out.println(ServerPlayer);
			if (i == 1) {
				ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20));
				ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20));
				ServerPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20));

				// Spawm Haunted Herobrine
				HeroBrineEntity herobrine = new HeroBrineEntity(EnhancedCraft.HEROBRINE, ServerPlayer.world);
				BlockPos playerPos = new BlockPos(ServerPlayer.getPos().add(ServerPlayer.getRotationVector().multiply(1)));
				System.out.println(playerPos);
				herobrine.setPos(playerPos.getX(), playerPos.getY(), playerPos.getZ());
				ServerPlayer.world.spawnEntity(herobrine);
				System.out.println(herobrine);

				cir.cancel();
			}
		}
	}
}
