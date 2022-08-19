package net.illia.illiatestmod.items;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.armor.materials.ModArmorMaterials;
import net.illia.illiatestmod.block.ModBlockEntities;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.items.custom.RubyMaterialItem;
import net.illia.illiatestmod.items.custom.ThrowableRubyItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class ModItems {
	public static final Item ILLIA_CUBE_SPAWN_EGG = new SpawnEggItem(ModEntities.ILLIA_CUBE, 12895428, 11382189, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY = new RubyMaterialItem(new Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY_HELMET = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_CHESTPLATE = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_LEGGINGS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_BOOTS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item THROWABLE_RUBY = new ThrowableRubyItem(new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).maxCount(16));

	public static void register() {
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "illia_cube_spawn_egg"), ModItems.ILLIA_CUBE_SPAWN_EGG);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby"), ModItems.RUBY);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_helmet"), ModItems.RUBY_HELMET);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_chestplate"), ModItems.RUBY_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_leggings"), ModItems.RUBY_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_boots"), ModItems.RUBY_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "throwable_ruby"), ModItems.THROWABLE_RUBY);
	}
}
