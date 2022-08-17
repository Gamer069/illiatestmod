package net.illia.illiatestmod.tool.material;

import net.illia.illiatestmod.item.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 100000;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 25.0F;
	}

	@Override
	public float getAttackDamage() {
		return 17.0F;
	}

	@Override
	public int getMiningLevel() {
		return 20;
	}

	@Override
	public int getEnchantability() {
		return 16;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModItems.RUBY);
	}
}
