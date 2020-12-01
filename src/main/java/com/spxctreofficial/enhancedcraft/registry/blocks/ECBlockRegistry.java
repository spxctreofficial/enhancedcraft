package com.spxctreofficial.enhancedcraft.registry.blocks;

import com.spxctreofficial.enhancedcraft.EnhancedCraft;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ECBlockRegistry {

	// Block Definitions
	public static final Block OTHERSTONE_BLOCK = new OtherstoneBlock();
	public static final Block EARTHSTONE_BLOCK = new EarthstoneBlock();

	public static final Block ETHERIUM_ORE_BLOCK = new EtheriumOreBlock();
	public static final Block BRONZE_ORE_BLOCK = new BronzeOreBlock();
	public static final Block GEMSTONE_BLOCK = new GemstoneBlock();
	public static final Block COBALT_ORE_BLOCK = new CobaltOreBlock();
	public static final Block FORTISTEEL_EARTHSTONE_BLOCK = new FortisteelEarthstoneBlock();
	public static final Block FORTISTEEL_OTHERSTONE_BLOCK = new FortisteelOtherstoneBlock();
	public static final Block PURIGOLD_EARTHSTONE_BLOCK = new PurigoldEarthstoneBlock();
	public static final Block PURIGOLD_OTHERSTONE_BLOCK = new PurigoldOtherstoneBlock();

	public static final Block ETHERIUM_BLOCK = new EtheriumBlock();
	public static final Block BRONZE_BLOCK = new BronzeBlock();

	public static final Block TROLL_TNT_BLOCK = new TrollTntBlock();

	public static final Block GOLDEN_HEAD_BLOCK = new SkullBlock(CustomSkullType.GOLDEN_HEAD, AbstractBlock.Settings.of(Material.SUPPORTED).strength(1.0F)) {};
	public static final Block GOLDEN_HEAD_WALL_BLOCK = new WallSkullBlock(CustomSkullType.GOLDEN_HEAD, AbstractBlock.Settings.of(Material.SUPPORTED).strength(1.0F).dropsLike(GOLDEN_HEAD_BLOCK)) {};

	public static final CustomPortalBlock CUSTOM_PORTAL_BLOCK = new CustomPortalBlock(Block.Settings.of(Material.PORTAL).noCollision().strength(-1).sounds(BlockSoundGroup.GLASS).luminance(state -> 11));
	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "otherstone"), OTHERSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "earthstone"), EARTHSTONE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_ore"), ETHERIUM_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "gemstone"), GEMSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_ore"), BRONZE_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "cobalt_ore"), COBALT_ORE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_earthstone"), FORTISTEEL_EARTHSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "fortisteel_ore_otherstone"), FORTISTEEL_OTHERSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_earthstone"), PURIGOLD_EARTHSTONE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "purigold_ore_otherstone"), PURIGOLD_OTHERSTONE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "etherium_block"), ETHERIUM_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "bronze_block"), BRONZE_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "troll_tnt"), TROLL_TNT_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "golden_head"), GOLDEN_HEAD_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "golden_head_wall"), GOLDEN_HEAD_WALL_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(EnhancedCraft.MOD_ID, "custom_portal_block"), CUSTOM_PORTAL_BLOCK);
	}
}
