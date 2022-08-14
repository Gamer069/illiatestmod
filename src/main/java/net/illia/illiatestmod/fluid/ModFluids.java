package net.illia.illiatestmod.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.items.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
	public static FlowableFluid STILL_MELTED_RUBY;
	public static FlowableFluid FLOWING_MELTED_RUBY;
	public static Block MELTED_RUBY_FLUID_BLOCK;
	public static Item MELTED_RUBY_BUCKET;
	public static void register() {
		STILL_MELTED_RUBY = Registry.register(Registry.FLUID, new Identifier(IlliaTestMod.MOD_ID, "melted_ruby"), new MeltedRubyFluid.Still());
		FLOWING_MELTED_RUBY = Registry.register(Registry.FLUID, new Identifier(IlliaTestMod.MOD_ID, "flowing_melted_ruby"), new MeltedRubyFluid.Flowing());
		MELTED_RUBY_FLUID_BLOCK = Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "melted_ruby_fluid_block"), new FluidBlock(ModFluids.STILL_MELTED_RUBY, FabricBlockSettings.copyOf(Blocks.WATER)){ });
		MELTED_RUBY_BUCKET = Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "melted_ruby_bucket"), new BucketItem(STILL_MELTED_RUBY, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItemGroups.ILLIA_TEST_MOD)));
	}
}
