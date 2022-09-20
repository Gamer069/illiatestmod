package net.illia.illiatestmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.effect.ModEffects;
import net.illia.illiatestmod.enchantment.ModEnchantments;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.fluid.ModFluids;
import net.illia.illiatestmod.item.ModItemGroups;
import net.illia.illiatestmod.item.ModItems;
import net.illia.illiatestmod.neededclasses.FabricLanguageProvider;
import net.illia.illiatestmod.neededclasses.TranslationConsumer;
import net.illia.illiatestmod.potion.ModPotions;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class IlliaTestModDatagen implements DataGeneratorEntrypoint {
	private static final TagKey<Item> BAD_FOOD = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:bad_food"));
	private static final TagKey<Item> GOD_FOOD = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:god_food"));
	private static final TagKey<Item> TEST = TagKey.of(Registry.ITEM_KEY, new Identifier("illiatestmod:test"));
	private static final TagKey<Block> ITM_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier("illiatestmod:itm_blocks"));
	private static class IlliaTestModItemTagGenerator extends FabricTagProvider<Item> {
		public IlliaTestModItemTagGenerator(FabricDataGenerator generator) {
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
			ShapedRecipeJsonBuilder.create(ModItems.FREEZE_BOW, 1).input('#', Ingredient.ofItems(Items.BOW)).input('L', Ingredient.ofItems(Items.ICE)).pattern("LLL").pattern("L#L").pattern("LLL").criterion("has_ice", RecipeProvider.conditionsFromItem(Items.ICE)).offerTo(exporter);
			ShapelessRecipeJsonBuilder.create(ModItems.RUBY, 1).input(Ingredient.ofItems(ModBlocks.RUBY_BLOCK)).criterion("has_ruby_block", RecipeProvider.conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(exporter);
			ShapedRecipeJsonBuilder.create(ModBlocks.RUBY_BLOCK, 1).input('#', Ingredient.ofItems(ModItems.RUBY)).pattern("###").pattern("###").pattern("###").criterion("has_ruby_block", RecipeProvider.conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(exporter);
		}
	}
	private static class IlliaTestModModelGen extends FabricModelProvider {
		public IlliaTestModModelGen(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_BLOCK);
			blockStateModelGenerator.registerSimpleCubeAll(ModFluids.MELTED_RUBY_FLUID_BLOCK);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIAMOND_CRAFTING_TABLE);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_TNT);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_SLAB);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_STAIRS);
			blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(ModItems.RED_BLOCK_ITEM, Models.GENERATED);
			itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
		}
	}
	private static class IlliaTestModBlockTagGen extends FabricTagProvider<Block> {
		public IlliaTestModBlockTagGen(FabricDataGenerator dataGenerator) {
			super(dataGenerator, Registry.BLOCK);
		}

		@Override
		protected void generateTags() {
			getOrCreateTagBuilder(IlliaTestModDatagen.ITM_BLOCKS).add(ModBlocks.RED_BLOCK).add(ModBlocks.RUBY_BLOCK).add(ModBlocks.TEST_TNT).add(ModBlocks.DIAMOND_CRAFTING_TABLE);
		}
	}
	private static class IlliaTestModLangGen extends FabricLanguageProvider {
		public IlliaTestModLangGen(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateTranslations(TranslationConsumer translationConsumer) {
			translationConsumer.add(ModItems.RUBY, "Ruby");
			translationConsumer.add(ModBlocks.RED_BLOCK, "Red Block");
			translationConsumer.add(ModItems.FREEZE_BOW, "Freeze Bow");
			translationConsumer.add(ModItems.ILLIA_CUBE_SPAWN_EGG, "Illia Cube Spawn Egg");
			translationConsumer.add(ModItems.RUBY_AXE, "Ruby Axe");
			translationConsumer.add(ModItems.RUBY_BOOTS, "Ruby Boots");
			translationConsumer.add(ModItems.RUBY_CHESTPLATE, "Ruby Chestplate");
			translationConsumer.add(ModItems.RUBY_HOE, "Ruby Hoe");
			translationConsumer.add(ModItems.RUBY_HELMET, "Ruby Helmet");
			translationConsumer.add(ModItems.RUBY_PICKAXE, "Ruby Pickaxe");
			translationConsumer.add(ModItems.RUBY_SWORD, "Ruby Sword");
			translationConsumer.add(ModItems.RUBY_SHOVEL, "Ruby Shovel");
			translationConsumer.add(ModItems.RUBY_LEGGINGS, "Ruby Leggings");
			translationConsumer.add(ModBlocks.RUBY_BLOCK, "Ruby Leggings");
			translationConsumer.add(ModBlocks.RUBY_SLAB, "Ruby Slab");
			translationConsumer.add(ModBlocks.RUBY_STAIRS, "Ruby Stairs");
			translationConsumer.add(ModItemGroups.ILLIA_TEST_MOD, "Illia Test Mod");
			translationConsumer.add(ModEnchantments.OP, "Op Enchantment");
			translationConsumer.add(ModEffects.TEST_EFFECT, "Test Effect");
			translationConsumer.add(ModPotions.TEST_POTION, "Test Potion");
			translationConsumer.add(ModEntities.ILLIA_CUBE, "Illia Cube");
			translationConsumer.add(ModBlocks.RUBY_ORE, "Ruby Ore");
		}
	}
	private static class IlliaTestModSimpleBlockLootGen extends SimpleFabricLootTableProvider {
		protected IlliaTestModSimpleBlockLootGen(FabricDataGenerator dataGenerator) {
			super(dataGenerator, LootContextTypes.BLOCK);
		}
		@Override
		public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
			biConsumer.accept(new Identifier(IlliaTestMod.MOD_ID, "ruby_ore"), BlockLootTableGenerator.drops(ModBlocks.RUBY_ORE, ModItems.RUBY));
		}
	}
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(IlliaTestModItemTagGenerator::new);
		fabricDataGenerator.addProvider(IlliaTestModRecipeGen::new);
		fabricDataGenerator.addProvider(IlliaTestModModelGen::new);
		fabricDataGenerator.addProvider(IlliaTestModBlockTagGen::new);
		fabricDataGenerator.addProvider(IlliaTestModLangGen::new);
		fabricDataGenerator.addProvider(IlliaTestModSimpleBlockLootGen::new);
	}
}
