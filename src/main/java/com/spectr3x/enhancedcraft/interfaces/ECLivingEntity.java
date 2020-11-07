package com.spectr3x.enhancedcraft.interfaces;

import net.minecraft.entity.LivingEntity;

public interface ECLivingEntity {
	LivingEntity getAsEntity();
	short getEtheriumEnrageStatus();
	short getEtheriumEnrageTime();
	void setEtheriumEnrageStatus(short n);
	void setEtheriumEnrageTime(short n);
}
