package com.spxctreofficial.enhancedcraft.mixin;


import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.BossBarManager;
import net.minecraft.entity.boss.CommandBossBar;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import net.minecraft.world.level.ServerWorldProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class BetterSleepPlus {
	@Shadow

	private boolean allPlayersSleeping;
	@Shadow
	@Final
	private List<ServerPlayerEntity> players;
	@Shadow
	@Final
	private ServerWorldProperties worldProperties;


	@Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V",
			at = @At(value = "FIELD", shift = At.Shift.BEFORE,
					target = "Lnet/minecraft/server/world/ServerWorld;allPlayersSleeping:Z", ordinal = 0))
	private void customSleepingMechanic(final BooleanSupplier shouldKeepTicking, final CallbackInfo ci) {
		ServerWorld instance = (ServerWorld) (Object) this;
		allPlayersSleeping = false;
		int asleepplayers = 0, playersOverworld = 0, wakeuptime = 1, sleeptime = 1;
		for (ServerPlayerEntity player : instance.getServer().getPlayerManager().getPlayerList()) {
			if (!player.world.getDimension().hasSkyLight()) {
				return;
			}
			playersOverworld++;
			if (player.isSleeping()) {
				asleepplayers++;
			}
		}
		Identifier bossid = new Identifier("bettersleepplus:bossbar");
		BossBarManager bossBarManager = instance.getServer().getBossBarManager();
		CommandBossBar commandBossBar = bossBarManager.get(bossid);
		if(!(bossBarManager.getIds().contains(bossid))){
			Text name = new LiteralText("sleep");
			commandBossBar = bossBarManager.add(bossid, name);
			commandBossBar.setMaxValue(1000);
			commandBossBar.setColor(BossBar.Color.BLUE);
		}

		if(instance.isRaining()){
			sleeptime = 12010;
			wakeuptime = 23992;
		} else {
			sleeptime = 12542;
			wakeuptime = 23460;
		}


		System.out.println(playersOverworld + "/" + asleepplayers);
		if (playersOverworld != 0 && asleepplayers != 0) {
			Text commandBossBartext;
			Formatting playerDecimalColor;
			double curve = 0.2;
			double playerDecimal = asleepplayers / (double) playersOverworld;
			double timeStep = (59 * (curve * playerDecimal / (2 * curve * playerDecimal - curve - playerDecimal + 1)));
			worldProperties.setTimeOfDay(worldProperties.getTimeOfDay() + (long) timeStep);
			if (worldProperties.getRainTime() > 60) { worldProperties.setRainTime(worldProperties.getRainTime() - (int) timeStep); }
			if (worldProperties.getThunderTime() > 60) { worldProperties.setThunderTime(worldProperties.getThunderTime() - (int) timeStep); }
			if (worldProperties.getClearWeatherTime() > 60) { worldProperties.setClearWeatherTime(worldProperties.getClearWeatherTime() - (int) timeStep); }
			instance.getServer().getPlayerManager().sendToDimension(new WorldTimeUpdateS2CPacket(instance.getTime(), instance.getTimeOfDay(), instance.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)), instance.getRegistryKey());
			if(!((worldProperties.getThunderTime() > 60) && worldProperties.isThundering())){
				commandBossBar.setColor(BossBar.Color.YELLOW);
				commandBossBar.setValue((int) ((((double) (instance.getTimeOfDay() % 24000L) - sleeptime) / (wakeuptime - sleeptime) * 1000)));
				commandBossBartext = new LiteralText("Night Progress [ETA: " + (Math.round(((wakeuptime - (instance.getTimeOfDay() % 24000L)) / ((timeStep + 1) * 20d)) * 10)) / 10d + "s]").formatted(Formatting.AQUA);
			}
			else {
				commandBossBar.setColor(BossBar.Color.PURPLE);
				commandBossBar.setValue((int) ((((double) (instance.getTimeOfDay() % 24000L) / 24000 * 1000))));
				commandBossBartext = new LiteralText("Thunder Progress [ETA: " + (Math.round(((worldProperties.getThunderTime() - 60) / ((timeStep + 1) * 20d)) * 10)) / 10d + "s]").formatted(Formatting.AQUA);
			}
			commandBossBar.addPlayers(players);
			System.out.println("true");
			commandBossBar.setVisible(true);
			commandBossBar.setName(commandBossBartext);
			switch((int) Math.round(playerDecimal * 2)){
				case 0:
					playerDecimalColor = Formatting.RED;
					break;
				case 1:
					playerDecimalColor = Formatting.YELLOW;
					break;
				case 2:
					playerDecimalColor = Formatting.GREEN;
					break;
				default:
					playerDecimalColor = Formatting.AQUA;
			}
			for(ServerPlayerEntity player : instance.getServer().getPlayerManager().getPlayerList()) {
				Text Message =
						new LiteralText("Player's sleeping ").formatted(Formatting.WHITE).append(
								new LiteralText("[").formatted(Formatting.GRAY).append(
										new LiteralText(asleepplayers + "/" + playersOverworld).formatted(playerDecimalColor).append(
												new LiteralText("]").formatted(Formatting.GRAY)
										)));
				player.sendMessage(Message, true);
			}
		}
		else {
			System.out.println("false");
			commandBossBar.setVisible(false);
		}
	}
}