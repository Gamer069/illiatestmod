package net.illia.illiatestmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.block.custom.DiamondCraftingTable;
import net.illia.illiatestmod.block.custom.TestTntBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final DiamondCraftingTable DIAMOND_CRAFTING_TABLE = new DiamondCraftingTable(FabricBlockSettings.of(Material.METAL).requiresTool().strength(4f).hardness(3f));
	public static final Block TEST_TNT = new TestTntBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(0.1f).hardness(0.1f));
	public static final Block RUBY_BLOCK = new TestTntBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(4.0f).hardness(4.0f));
	public static final Block RED_BLOCK = new Block(FabricBlockSettings.of(Material.FROGLIGHT).breakInstantly().requiresTool().strength(1.0f).hardness(1.0f));
	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "diamond_crafting_table"), ModBlocks.DIAMOND_CRAFTING_TABLE);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "ruby_block"), ModBlocks.RUBY_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "red_block"), ModBlocks.RED_BLOCK);
	}
}
