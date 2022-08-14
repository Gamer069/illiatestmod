package net.illia.illiatestmod.block.custom;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.ImplementedInventory;
import net.illia.illiatestmod.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondChestEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
	private int number = 7;
	private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
	public DiamondChestEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.DIAMOND_CHEST_ENTITY, pos, state);
	}
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, items);
		number = nbt.getInt("number");
		markDirty();
	}
	@Override
	protected void writeNbt(NbtCompound nbt) {
		nbt.putInt("number", number);
		super.writeNbt(nbt);
	}
	public static void tick(World world, BlockPos pos, BlockState state, DiamondChestEntity be) {

	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return items;
	}

	@Override
	public int[] getAvailableSlots(Direction side) {
		int[] result = new int[getItems().size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}

	@Override
	public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
		return dir != Direction.UP;
	}

	@Override
	public boolean canExtract(int slot, ItemStack stack, Direction dir) {
		return true;
	}
}
