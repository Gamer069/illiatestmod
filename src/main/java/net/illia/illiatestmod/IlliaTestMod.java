package net.illia.illiatestmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IlliaTestMod implements ModInitializer {
	public static final String MOD_ID = "illiatestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(IlliaTestMod.MOD_ID);
	public static final ItemGroup ILLIA_TEST_MOD = FabricItemGroupBuilder.build(new Identifier(IlliaTestMod.MOD_ID, "illiatestmod"), () -> new ItemStack(Items.BARRIER));
	public static final Item RUBY = new Item(new FabricItemSettings().group(IlliaTestMod.ILLIA_TEST_MOD));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby"), RUBY);
		LOGGER.info("Hello Fabric world!");
	}
}
