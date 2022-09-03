package net.illia.illiatestmod.item;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.armor.materials.ModArmorMaterials;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.util.registry.Registry.*;

public class ModItems {
	public static final Item ILLIA_CUBE_SPAWN_EGG = new SpawnEggItem(ModEntities.ILLIA_CUBE, 12895428, 11382189, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY = new RubyMaterialItem(new Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY_HELMET = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_CHESTPLATE = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_LEGGINGS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_BOOTS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final ToolItem RUBY_SWORD = new SwordItem(RubyMaterialItem.INSTANCE, 3, -2.4F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyMaterialItem.INSTANCE, 1.5F, -3.0F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final ToolItem RUBY_PICKAXE = new RubyPickaxeItem(RubyMaterialItem.INSTANCE, 1, -2.8F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final ToolItem RUBY_AXE = new RubyAxeItem(RubyMaterialItem.INSTANCE, 7, -3.2F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final ToolItem RUBY_HOE = new RubyHoeItem(RubyMaterialItem.INSTANCE, 7, -3.2F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item FREEZE_BOW = new FreezeBow(new Settings().group(ModItemGroups.ILLIA_TEST_MOD).maxCount(1));
	public static final BlockItem RED_BLOCK_ITEM = new BlockItem(ModBlocks.RED_BLOCK, new Settings().group(ModItemGroups.ILLIA_TEST_MOD));

	public static void register() {
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "illia_cube_spawn_egg"), ModItems.ILLIA_CUBE_SPAWN_EGG);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby"), ModItems.RUBY);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_helmet"), ModItems.RUBY_HELMET);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_chestplate"), ModItems.RUBY_CHESTPLATE);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_leggings"), ModItems.RUBY_LEGGINGS);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_boots"), ModItems.RUBY_BOOTS);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_hoe"), ModItems.RUBY_HOE);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_axe"), ModItems.RUBY_AXE);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_pickaxe"), ModItems.RUBY_PICKAXE);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_shovel"), ModItems.RUBY_SHOVEL);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_sword"), ModItems.RUBY_SWORD);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "freeze_bow"), ModItems.FREEZE_BOW);
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "test_tnt"), new BlockItem(ModBlocks.TEST_TNT, new Settings().group(ModItemGroups.ILLIA_TEST_MOD)));
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_block"), new BlockItem(ModBlocks.RUBY_BLOCK, new Settings().group(ModItemGroups.ILLIA_TEST_MOD)));
		Registry.register(ITEM, new Identifier(IlliaTestMod.MOD_ID, "red_block"), ModItems.RED_BLOCK_ITEM);
	}
}
