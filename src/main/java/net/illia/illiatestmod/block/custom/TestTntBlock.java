package net.illia.illiatestmod.block.custom;

import net.illia.illiatestmod.entity.tnt.TestTntEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

import javax.annotation.Nullable;

public class TestTntBlock extends Block {
	public static final BooleanProperty UNSTABLE = Properties.UNSTABLE;
	public TestTntBlock(AbstractBlock.Settings settings) {
		super(settings);
		this.setDefaultState((BlockState)this.getDefaultState().with(UNSTABLE, false));
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (oldState.isOf(state.getBlock())) {
			return;
		}
		if (world.isReceivingRedstonePower(pos)) {
			TestTntBlock.primeTnt(world, pos);
			world.removeBlock(pos, false);
		}
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
		if (world.isReceivingRedstonePower(pos)) {
			TestTntBlock.primeTnt(world, pos);
			world.removeBlock(pos, false);
		}
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!world.isClient && !player.isCreative() && state.get(UNSTABLE).booleanValue()) {
			TestTntBlock.primeTnt(world, pos);
		}
		super.onBreak(world, pos, state, player);
	}

	@Override
	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		if (world.isClient) return;
		TestTntEntity tnt = new TestTntEntity(world, (double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, explosion.getCausingEntity());
		int i = tnt.getFuse();
		tnt.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
		world.spawnEntity(tnt);
	}
	public static void primeTnt(World world, BlockPos pos) {
		TestTntBlock.primeTnt(world, pos, null);

	}
	private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
		if (world.isClient) return;
		TestTntEntity tnt = new TestTntEntity(world, (double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, igniter);
		world.spawnEntity(tnt);
		world.playSound(null, tnt.getX(), tnt.getY(), tnt.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
		world.emitGameEvent((Entity)igniter, GameEvent.PRIME_FUSE, pos);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
		ItemStack stack = player2.getStackInHand(hand);
		if (stack.isOf(Items.FLINT_AND_STEEL) || stack.isOf(Items.FIRE_CHARGE)) {
			TestTntBlock.primeTnt(world, pos, player2);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
			Item item = stack.getItem();
			if (!player2.isCreative()) {
				if (stack.isOf(Items.FLINT_AND_STEEL)) {
					stack.damage(1, player2, player -> player.sendToolBreakStatus(hand));
				} else {
					stack.decrement(1);
				}
			}
			player2.incrementStat(Stats.USED.getOrCreateStat(item));
			return ActionResult.success(world.isClient);
		}
		return super.onUse(state, world, pos, player2, hand, hit);
	}

	@Override
	public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
		if (!world.isClient) {
			BlockPos pos = hit.getBlockPos();
			Entity entity = projectile.getOwner();
			if (projectile.isOnFire() && projectile.canModifyAt(world, pos)) {
				TestTntBlock.primeTnt(world, pos, entity instanceof LivingEntity ? (LivingEntity)entity : null);
				world.removeBlock(pos, false);
			}
		}
	}

	@Override
	public boolean shouldDropItemsOnExplosion(Explosion explosion) {
		return false;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(UNSTABLE);
	}
}
