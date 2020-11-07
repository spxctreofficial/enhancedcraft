package com.spxctreofficial.enhancedcraft.interfaces;

import net.minecraft.entity.LivingEntity;

public interface ECLivingEntity {
	LivingEntity getAsEntity();
	short getEtheriumEnrageStatus();
	short getEtheriumEnrageTime();
	boolean getIsEtheriumEnrageMaxed();
	void setEtheriumEnrageStatus(short n);
	void setEtheriumEnrageTime(short n);
	void setIsEtheriumEnrageMaxed(boolean bool);
}
