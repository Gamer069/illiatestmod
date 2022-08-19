package net.illia.illiatestmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class DiamondChestScreenHandler extends ScreenHandler {
	private final Inventory inventory;
	public DiamondChestScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(2));
	}
	public DiamondChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(ModScreenHandlers.DIAMOND_CHEST_SCREEN_HANDLER, syncId);
		checkSize(inventory, 2);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);
		int m;
		int l;
		for (m = 0; m < 3; ++m) {
			for (l = 0; l < 2; ++l) {
				this.addSlot(new Slot(inventory, l + m * 3, 62 + l * 18, 17 + m * 18));
			}
		}
		for (m = 0; m < 3; ++m) {
			for (l = 0; l < 2; ++l) {
				this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
			}
		}
		for (m = 0; m < 9; ++m) {
			this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
		}
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}
	@Override
	public ItemStack transferSlot(PlayerEntity player, int index) {
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasStack()) {
			ItemStack originalStack = slot.getStack();
			newStack = originalStack.copy();
			if (index < this.inventory.size()) {
				if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) return ItemStack.EMPTY;
			} else if (this.insertItem(originalStack, 0, this.inventory.size(), false)) return ItemStack.EMPTY;
			if (originalStack.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
		}
		return newStack;
	}
}
