package com.spectr3x.enhancedcraft.registry.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

public class SoakedHandsMusicDisc extends MusicDiscItem {

	public SoakedHandsMusicDisc(int comparatorOutput, SoundEvent sound) {
		super(comparatorOutput, sound, new Item.Settings().group(ItemGroup.MISC).maxCount(1).rarity(Rarity.EPIC));
    }
}
