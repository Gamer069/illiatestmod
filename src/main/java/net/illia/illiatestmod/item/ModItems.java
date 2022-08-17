package net.illia.illiatestmod.item;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.armor.materials.ModArmorMaterials;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.item.custom.RubyAxeItem;
import net.illia.illiatestmod.item.custom.RubyHoeItem;
import net.illia.illiatestmod.item.custom.RubyMaterialItem;
import net.illia.illiatestmod.item.custom.RubyPickaxeItem;
import net.illia.illiatestmod.tool.material.RubyToolMaterial;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item ILLIA_CUBE_SPAWN_EGG = new SpawnEggItem(ModEntities.ILLIA_CUBE, 12895428, 11382189, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY = new RubyMaterialItem(new Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static final Item RUBY_HELMET = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_CHESTPLATE = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_LEGGINGS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static final Item RUBY_BOOTS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static ToolItem RUBY_SWORD = new SwordItem(RubyMaterialItem.INSTANCE, 3, -2.4F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static ToolItem RUBY_SHOVEL = new ShovelItem(RubyMaterialItem.INSTANCE, 1.5F, -3.0F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static ToolItem RUBY_PICKAXE = new RubyPickaxeItem(RubyMaterialItem.INSTANCE, 1, -2.8F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static ToolItem RUBY_AXE = new RubyAxeItem(RubyMaterialItem.INSTANCE, 7, -3.2F, new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());
	public static ToolItem RUBY_HOE = new RubyHoeItem(RubyMaterialItem.INSTANCE, 7, -3.2F, new Settings().group(ModItemGroups.ILLIA_TEST_MOD).fireproof());

	public static void register() {
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "illia_cube_spawn_egg"), ModItems.ILLIA_CUBE_SPAWN_EGG);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby"), ModItems.RUBY);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_helmet"), ModItems.RUBY_HELMET);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_chestplate"), ModItems.RUBY_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_leggings"), ModItems.RUBY_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_boots"), ModItems.RUBY_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_hoe"), ModItems.RUBY_HOE);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_axe"), ModItems.RUBY_AXE);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_pickaxe"), ModItems.RUBY_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_shovel"), ModItems.RUBY_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(IlliaTestMod.MOD_ID, "ruby_sword"), ModItems.RUBY_SWORD);
	}
}
