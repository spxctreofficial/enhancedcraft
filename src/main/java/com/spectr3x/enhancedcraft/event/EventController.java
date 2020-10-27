package com.spectr3x.enhancedcraft.event;

import com.spectr3x.enhancedcraft.event.bonuses.armorBonuses.ArmorBonusEvent;

public class EventController {
	public static void InitiateEvents() {
		DeteriorationEvent.Deterioration();

		ArmorBonusEvent.Instantiate();
	}
}
