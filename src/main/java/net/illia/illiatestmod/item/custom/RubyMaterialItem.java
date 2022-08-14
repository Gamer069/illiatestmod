package net.illia.illiatestmod.item.custom;

import net.illia.illiatestmod.item.ModItemGroups;
import net.illia.illiatestmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyMaterialItem extends Item implements ToolMaterial {
	public static final RubyMaterialItem INSTANCE = new RubyMaterialItem(new Item.Settings().group(ModItemGroups.ILLIA_TEST_MOD));

	public RubyMaterialItem(Settings settings) {
		super(settings);
	}

	@Override
	public int getDurability() {
		return 500;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0F;
	}

	@Override
	public float getAttackDamage() {
		return 4.0F;
	}

	@Override
	public int getMiningLevel() {
		return 4;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModItems.RUBY);
	}

	@Override
	public int getEnchantability() {
		return 16;
	}
}
