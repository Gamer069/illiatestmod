package net.illia.illiatestmod.enchantment;

import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
	public static Enchantment TEST = new TestEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	public static void register() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(IlliaTestMod.MOD_ID, "testenchantment"), ModEnchantments.TEST);
	}
}
