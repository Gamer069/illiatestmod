package net.illia.illiatestmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.block.custom.DiamondChest;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static DiamondChest DIAMOND_CHEST = new DiamondChest(FabricBlockSettings.of(Material.METAL).hardness(3.0f));
	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest"), ModBlocks.DIAMOND_CHEST);
	}
}
