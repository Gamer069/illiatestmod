package net.illia.illiatestmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.block.custom.DiamondCraftingTable;
import net.illia.illiatestmod.block.custom.TestTntBlock;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class ModBlocks {
	public static final HashMap<String, Block> BLOCKS = new HashMap<>();
	public static final DiamondCraftingTable DIAMOND_CRAFTING_TABLE = new DiamondCraftingTable(FabricBlockSettings.of(Material.METAL).requiresTool().strength(4f).hardness(3f));
	public static final Block TEST_TNT = new TestTntBlock(FabricBlockSettings.of(Material.METAL).breakInstantly().requiresTool().strength(0.1f).hardness(0.1f));
	public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(4.0f).hardness(4.0f));
	public static final Block RED_BLOCK = new Block(FabricBlockSettings.of(Material.FROGLIGHT).breakInstantly().requiresTool().strength(1.0f).hardness(1.0f));
	public static final Block RUBY_STAIRS = new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).requiresTool().hardness(2.0f).strength(2.0f));
	public static final Block RUBY_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL).requiresTool().hardness(2.0f).strength(2.0f));
	public static final OreBlock RUBY_ORE = new OreBlock(FabricBlockSettings.of(Material.METAL), new IntProvider() {
		@Override
		public int get(Random random) {
			return random.nextBetween(getMin(), getMax());
		}

		@Override
		public int getMin() {
			return 5;
		}

		@Override
		public int getMax() {
			return 10;
		}

		@Override
		public IntProviderType<?> getType() {
			return IntProviderType.CONSTANT;
		}
	});
	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "diamond_crafting_table"), ModBlocks.DIAMOND_CRAFTING_TABLE);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "ruby_block"), ModBlocks.RUBY_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "red_block"), ModBlocks.RED_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "test_tnt"), ModBlocks.TEST_TNT);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "ruby_slab"), ModBlocks.RUBY_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "ruby_stairs"), ModBlocks.RUBY_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "ruby_ore"), ModBlocks.RUBY_ORE);
	}
}
