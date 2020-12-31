package com.spxctreofficial.enhancedcraft.interfaces;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public interface ECLivingEntity {

	LivingEntity getAsEntity();

	// Etherium Variables
	short getEtheriumEnrageStatus();
	short getEtheriumEnrageTime();
	boolean getIsEtheriumEnrageMaxed();
	void setEtheriumEnrageStatus(short n);
	void setEtheriumEnrageTime(short n);
	void setIsEtheriumEnrageMaxed(boolean bool);

	// Aecoron Variables
	short getAecoronRiptideSwimSpeedBonus();
	short getAecoronRiptideMaxSwimSpeedBonus();
	short getAecoronTimeToHeal();
	short getAecoronTimeToHealMax();
	Vec3d getAecoronStartPos();
	void setAecoronRiptideSwimSpeedBonus(short n);
	void setAecoronTimeToHeal(short n);
	void setAecoronStartPos(Vec3d vec3d);

	// Cobalt Variables
	short getCobaltShieldTick();
	short getCobaltShieldMaxTick();
	void setCobaltShieldTick(short n);
}
