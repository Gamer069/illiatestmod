package net.illia.illiatestmod.armor.materials;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.materials.RubyAmorMaterial;
import net.minecraft.item.ArmorMaterial;

public class ModArmorMaterials {
	public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new RubyAmorMaterial();
	public static void register() {
		IlliaTestMod.LOGGER.debug("Armor Materials Have Been Registered");
	}
}
