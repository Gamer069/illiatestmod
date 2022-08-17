package net.illia.illiatestmod.item.custom;

import net.illia.illiatestmod.item.ModItemGroups;
import net.illia.illiatestmod.item.ModItems;
import net.illia.illiatestmod.tool.material.RubyToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyMaterialItem extends Item {
	public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();
	public RubyMaterialItem(Settings settings) {
		super(settings);
	}
}
