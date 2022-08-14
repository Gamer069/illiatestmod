package net.illia.illiatestmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.illia.illiatestmod.block.custom.DiamondChest;
import net.illia.illiatestmod.block.custom.DiamondChestEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IlliaTestMod implements ModInitializer {
	public static final String MOD_ID = "illiatestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(IlliaTestMod.MOD_ID);
	public static final DiamondChest DIAMOND_CHEST = new DiamondChest(FabricBlockSettings.of(Material.METAL).hardness(3.0f));
	public static final ItemGroup ILLIA_TEST_MOD = FabricItemGroupBuilder.build(new Identifier(IlliaTestMod.MOD_ID, "illiatestmod"), () -> new ItemStack(Items.BARRIER));
	public static final Item RUBY = new Item(new FabricItemSettings().group(IlliaTestMod.ILLIA_TEST_MOD));
	public static final BlockEntityType<DiamondChestEntity> DIAMOND_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest_entity"), FabricBlockEntityTypeBuilder.create(DiamondChestEntity::new, IlliaTestMod.DIAMOND_CHEST).build());
	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest"), IlliaTestMod.DIAMOND_CHEST);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest"), new BlockItem(IlliaTestMod.DIAMOND_CHEST, new Item.Settings().group(IlliaTestMod.ILLIA_TEST_MOD)));
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby"), RUBY);
		LOGGER.info("Hello Fabric world!");
	}
}
