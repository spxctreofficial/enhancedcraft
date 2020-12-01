package com.spxctreofficial.enhancedcraft.registry;

import com.spxctreofficial.enhancedcraft.registry.blocks.ECBlockRegistry;
import com.spxctreofficial.enhancedcraft.registry.entity.ECEntityRegistry;
import com.spxctreofficial.enhancedcraft.registry.features.ECFeatureRegistry;
import com.spxctreofficial.enhancedcraft.registry.items.ECItemRegistry;
import com.spxctreofficial.enhancedcraft.registry.portals.ECPortalRegistry;
import com.spxctreofficial.enhancedcraft.registry.sounds.ECSoundRegistry;
import com.spxctreofficial.enhancedcraft.registry.statusEffects.ECStatusEffectRegistry;

public class ECRegistry {
	/*
	    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    	}

    	cool guy i509VCB advice
	 */
//	public static final Item GOLDEN_HEAD = new WallStandingBlockItem(GOLDEN_HEAD_BLOCK, GOLDEN_HEAD_WALL_BLOCK, (new Item.Settings()).group(ItemGroup.DECORATIONS).rarity(Rarity.UNCOMMON));
//	public static final BlockEntityType<SkullBlockEntity> CUSTOM_SKULLS =  BlockEntityType.Builder.create(SkullBlockEntity::new, GOLDEN_HEAD_BLOCK, GOLDEN_HEAD_WALL_BLOCK).build(null);

	public static void register() {
		ECItemRegistry.register();
		ECBlockRegistry.register();
		ECSoundRegistry.register();
		ECFeatureRegistry.register();
		ECPortalRegistry.register();
		ECStatusEffectRegistry.register();
		ECEntityRegistry.register();
//		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EnhancedCraft.MOD_ID, "custom_skulls"), CUSTOM_SKULLS);
	}
}