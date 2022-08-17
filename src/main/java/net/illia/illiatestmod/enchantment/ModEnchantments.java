package net.illia.illiatestmod.enchantment;

import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
	public static final Enchantment OP = new OPEnchantment();
	public static void register() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(IlliaTestMod.MOD_ID, "op"), ModEnchantments.OP);
	}
}
