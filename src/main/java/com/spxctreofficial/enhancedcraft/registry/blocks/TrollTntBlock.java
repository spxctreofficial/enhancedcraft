package com.spxctreofficial.enhancedcraft.registry.blocks;

import com.spxctreofficial.enhancedcraft.registry.entity.TrollTntEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class TrollTntBlock extends Block {
	public static final BooleanProperty UNSTABLE;

	public TrollTntBlock() {
		super(Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
		this.setDefaultState(this.getDefaultState().with(UNSTABLE, false));
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (!oldState.isOf(state.getBlock())) {
			if (world.isReceivingRedstonePower(pos)) {
				primeTnt(world, pos);
				world.removeBlock(pos, false);
			}

		}
	}

	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		if (world.isReceivingRedstonePower(pos)) {
			primeTnt(world, pos);
			world.removeBlock(pos, false);
		}

	}

	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!world.isClient() && !player.isCreative() && state.get(UNSTABLE)) {
			primeTnt(world, pos);
		}

		super.onBreak(world, pos, state, player);
	}

	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		if (!world.isClient) {
			TrollTntEntity tntEntity = new TrollTntEntity(world, (double)pos.getX() + 0.5D, pos.getY(), (double)pos.getZ() + 0.5D, explosion.getCausingEntity());
			tntEntity.setFuse(tntEntity.fuseTime);
			world.spawnEntity(tntEntity);
		}
	}

	public static void primeTnt(World world, BlockPos pos) {
		primeTnt(world, pos, null);
	}

	private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
		if (!world.isClient) {
			TrollTntEntity tntEntity = new TrollTntEntity(world, (double)pos.getX() + 0.5D, pos.getY(), (double)pos.getZ() + 0.5D, igniter);
			world.spawnEntity(tntEntity);
			world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
	}

	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getStackInHand(hand);
		Item item = itemStack.getItem();
		if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
			return super.onUse(state, world, pos, player, hand, hit);
		}
		else {
			primeTnt(world, pos, player);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
			if (!player.isCreative()) {
				itemStack.decrement(1);
			}

			return ActionResult.success(world.isClient);
		}
	}

	public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
		if (!world.isClient) {
			Entity entity = projectile.getOwner();
			if (projectile.isOnFire()) {
				BlockPos blockPos = hit.getBlockPos();
				primeTnt(world, blockPos, entity instanceof LivingEntity ? (LivingEntity)entity : null);
				world.removeBlock(blockPos, false);
			}
		}

	}

	public boolean shouldDropItemsOnExplosion(Explosion explosion) {
		return false;
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(UNSTABLE);
	}

	static {
		UNSTABLE = Properties.UNSTABLE;
	}
}
