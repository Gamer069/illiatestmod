package net.illia.illiatestmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.block.custom.DiamondCraftingTable;
import net.minecraft.block.Material;

public class ModBlocks {
	public static final DiamondCraftingTable DIAMOND_CRAFTING_TABLE = new DiamondCraftingTable(FabricBlockSettings.of(Material.METAL).requiresTool().strength(4f).hardness(3f));
	public static void register() {

	}
}
