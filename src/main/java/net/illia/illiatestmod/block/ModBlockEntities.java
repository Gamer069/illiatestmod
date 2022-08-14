package net.illia.illiatestmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.block.custom.DiamondChestEntity;
import net.illia.illiatestmod.items.ModItemGroups;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
	public static final BlockEntityType<DiamondChestEntity> DIAMOND_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest_entity"), FabricBlockEntityTypeBuilder.create(DiamondChestEntity::new, ModBlocks.DIAMOND_CHEST).build());
	public static void register() {
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "diamond_chest"), new BlockItem(ModBlocks.DIAMOND_CHEST, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD)));
	}
}
