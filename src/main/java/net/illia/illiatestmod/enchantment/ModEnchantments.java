package net.illia.illiatestmod.enchantment;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.item.ModItemGroups;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
	public static final Enchantment OP = new OPEnchantment(new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD));
	public static void register() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(IlliaTestMod.MOD_ID, "op"), ModEnchantments.OP);
	}
}
