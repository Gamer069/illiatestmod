package net.illia.illiatestmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class IlliaTestModDatagen implements DataGeneratorEntrypoint {
	private static final TagKey<Item> BAD_FOOD = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:bad_food"));
	private static final TagKey<Item> GOD_FOOD = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:god_food"));
	private static final TagKey<Item> TEST = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:test"));
	private static class IlliaTestModTagGenerator extends FabricTagProvider<Item> {
		public IlliaTestModTagGenerator(FabricDataGenerator generator) {
			super(generator, Registry.ITEM);
		}

		@Override
		protected void generateTags() {
			getOrCreateTagBuilder(IlliaTestModDatagen.BAD_FOOD).add(Items.ROTTEN_FLESH).add(Items.POISONOUS_POTATO);
			getOrCreateTagBuilder(IlliaTestModDatagen.GOD_FOOD).add(Items.ENCHANTED_GOLDEN_APPLE).add(Items.GOLDEN_CARROT).add(Items.GOLDEN_APPLE);
			getOrCreateTagBuilder(IlliaTestModDatagen.TEST).add(ModItems.FREEZE_BOW);
		}
	}
	private static class IlliaTestModRecipeGen extends FabricRecipeProvider {
		public IlliaTestModRecipeGen(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}
		@Override
		protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
			  ShapedRecipeJsonBuilder.create(ModItems.FREEZE_BOW, 1).input('#', Ingredient.ofItems(Items.BOW)).input('L', Ingredient.ofItems(Items.ICE)).pattern("LLL").pattern("L#L").pattern("LLL").offerTo(exporter);
			  ShapelessRecipeJsonBuilder.create(ModItems.RUBY, 1).input(Ingredient.ofItems(ModBlocks.RUBY_BLOCK)).offerTo(exporter);
			  ShapedRecipeJsonBuilder.create(ModBlocks.RUBY_BLOCK, 1).input('#', Ingredient.ofItems(ModItems.RUBY)).pattern("###").pattern("###").pattern("###").offerTo(exporter);
		}
	}
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(IlliaTestModTagGenerator::new);
		fabricDataGenerator.addProvider(IlliaTestModRecipeGen::new);
	}
}
