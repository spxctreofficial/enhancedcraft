package com.spxctreofficial.enhancedcraft.registry.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ECSoundRegistry {
	// SoundEvent Definitions
	public static final Identifier SOAKED_HANDS = new Identifier("enhancedcraft:soaked_hands");
	public static final Identifier YEAY_ID = new Identifier("enhancedcraft:yeay");

	public static final Identifier ETHERIUM_ARMOR_EQUIP = new Identifier("enhancedcraft:etherium_armor_equip");
	public static final Identifier ETHERIUM_BONUS_ACTIVATED = new Identifier("enhancedcraft:etherium_bonus_activated");
	public static final Identifier ETHERIUM_ENRAGED_SOUND = new Identifier("enhancedcraft:etherium_enraged_sound");
	public static final Identifier ETHERIUM_ENRAGED_KILL = new Identifier("enhancedcraft:etherium_enraged_kill");
	public static final Identifier ETHERIUM_ENRAGED_ENDED_SOUND = new Identifier("enhancedcraft:etherium_enraged_ended_sound");

	public static final Identifier AECORON_SIREN = new Identifier("enhancedcraft:aecoron_siren");
	public static final Identifier AECORON_SIRENS_CALL = new Identifier("enhancedcraft:aecoron_sirens_call");

	public static final Identifier SMART_PEARL_THROW = new Identifier("enhancedcraft:smart_pearl_throw");
	public static final Identifier SMART_PEARL_TELEPORT = new Identifier("enhancedcraft:smart_pearl_teleport");

	public static final SoundEvent SOAKED_HANDS_SOUND_EVENT = new SoundEvent(SOAKED_HANDS);
	public static final SoundEvent YEAY_SOUND_EVENT = new SoundEvent(YEAY_ID);

	public static final SoundEvent ETHERIUM_ARMOR_EQUIP_SOUND_EVENT = new SoundEvent(ETHERIUM_ARMOR_EQUIP);
	public static final SoundEvent ETHERIUM_BONUS_ACTIVATED_SOUND_EVENT = new SoundEvent(ETHERIUM_BONUS_ACTIVATED);
	public static final SoundEvent ETHERIUM_ENRAGED_SOUND_EVENT = new SoundEvent(ETHERIUM_ENRAGED_SOUND);
	public static final SoundEvent ETHERIUM_ENRAGED_KILL_SOUND_EVENT = new SoundEvent(ETHERIUM_ENRAGED_KILL);
	public static final SoundEvent ETHERIUM_ENRAGED_ENDED_SOUND_EVENT = new SoundEvent(ETHERIUM_ENRAGED_ENDED_SOUND);

	public static final SoundEvent AECORON_SIREN_SOUND_EVENT = new SoundEvent(AECORON_SIREN);
	public static final SoundEvent AECORON_SIRENS_CALL_SOUND_EVENT = new SoundEvent(AECORON_SIRENS_CALL);

	public static final SoundEvent SMART_PEARL_THROW_SOUND_EVENT = new SoundEvent(SMART_PEARL_THROW);
	public static final SoundEvent SMART_PEARL_TELEPORT_SOUND_EVENT = new SoundEvent(SMART_PEARL_TELEPORT);

	public static void register() {
		// SoundEvents Registry
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.SOAKED_HANDS, SOAKED_HANDS_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.YEAY_ID, YEAY_SOUND_EVENT);

		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.ETHERIUM_ARMOR_EQUIP, ETHERIUM_ARMOR_EQUIP_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.ETHERIUM_BONUS_ACTIVATED, ETHERIUM_BONUS_ACTIVATED_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.ETHERIUM_ENRAGED_SOUND, ETHERIUM_ENRAGED_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.ETHERIUM_ENRAGED_KILL, ETHERIUM_ENRAGED_KILL_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.ETHERIUM_ENRAGED_ENDED_SOUND, ETHERIUM_ENRAGED_ENDED_SOUND_EVENT);

		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.AECORON_SIREN, AECORON_SIREN_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.AECORON_SIRENS_CALL, AECORON_SIRENS_CALL_SOUND_EVENT);

		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.SMART_PEARL_THROW, SMART_PEARL_THROW_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, ECSoundRegistry.SMART_PEARL_TELEPORT, SMART_PEARL_TELEPORT_SOUND_EVENT);
	}
}
