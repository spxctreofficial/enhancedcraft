//package com.spxctreofficial.enhancedcraft.mixin;
//
//import com.spxctreofficial.enhancedcraft.interfaces.ECLivingEntity;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.text.LiteralText;
//import net.minecraft.text.Text;
//import net.minecraft.util.Formatting;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(ServerPlayerEntity.class)
//public abstract class ServerPlayerEntityMixin {
//
//	@Shadow public abstract void sendMessage(Text message, boolean actionBar);
//
//	ECLivingEntity user = (ECLivingEntity) this;
//
//	@Inject(method = "tick", at = @At("HEAD"))
//	private void tick(CallbackInfo info) {
//		if (user.getEtheriumEnrageStatus() == 3) {
//			Text Message =
//					new LiteralText("this is a test ").formatted(Formatting.WHITE);
//			this.sendMessage(Message, true);
//		}
//	}
//}
