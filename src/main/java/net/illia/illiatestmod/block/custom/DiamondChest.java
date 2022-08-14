package net.illia.illiatestmod.block.custom;

import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondChest extends BlockWithEntity implements BlockEntityProvider {
	public DiamondChest(Settings settings) {
		super(settings);
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new DiamondChestEntity(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return checkType(type, IlliaTestMod.DIAMOND_CHEST_ENTITY, (world1, pos1, state1, be) -> DiamondChestEntity.tick(world1, pos1, state1, be));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient()) return ActionResult.SUCCESS;
		Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);
		if (!player.getStackInHand(hand).isEmpty()) {
			if (blockEntity.getStack(0).isEmpty()) {
				blockEntity.setStack(0, player.getStackInHand(hand).copy());
				player.getStackInHand(hand).setCount(0);
			} else if (blockEntity.getStack(1).isEmpty()) {
				blockEntity.setStack(1, player.getStackInHand(hand).copy());
				player.getStackInHand(hand).setCount(0);
			} else {
				System.out.println("An Error Occurred While Shift Clicking, cos The First Slot Of The GUI Is Filled With " + blockEntity.getStack(0) + "The Fucking Second Slot Of The GUI Is Filled With " + blockEntity.getStack(1));
			}
		} else {
			if (!blockEntity.getStack(1).isEmpty()) {
				player.getInventory().offerOrDrop(blockEntity.getStack(1));
				blockEntity.removeStack(1);
			} else if (blockEntity.getStack(0).isEmpty()) {
				player.getInventory().offerOrDrop(blockEntity.getStack(0));
				blockEntity.removeStack(0);
			}
		}
		return ActionResult.SUCCESS;
	}
}
