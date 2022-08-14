package net.illia.illiatestmod.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static final ItemGroup ILLIA_TEST_MOD = FabricItemGroupBuilder.build(new Identifier(IlliaTestMod.MOD_ID, "illiatestmod"), () -> new ItemStack(ModItems.RUBY));
	public static void register() {
		System.out.println(ILLIA_TEST_MOD + " Has Been Registered?");
	}
}
