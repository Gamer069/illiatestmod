package net.illia.illiatestmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.illia.illiatestmod.armor.materials.ModArmorMaterials;
import net.illia.illiatestmod.block.ModBlockEntities;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.block.custom.DiamondChest;
import net.illia.illiatestmod.effect.ModEffects;
import net.illia.illiatestmod.enchantment.ModEnchantments;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.fluid.ModFluids;
import net.illia.illiatestmod.items.ModItemGroups;
import net.illia.illiatestmod.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IlliaTestMod implements ModInitializer {
	public static final String MOD_ID = "illiatestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(IlliaTestMod.MOD_ID);
	public static final Identifier DIAMOND_CHEST_IDENTIFIER = new Identifier(IlliaTestMod.MOD_ID, "diamond_chest");
	static {
		ModBlocks.DIAMOND_CHEST = Registry.register(Registry.BLOCK, DIAMOND_CHEST_IDENTIFIER, new DiamondChest(FabricBlockSettings.copyOf(Blocks.CHEST)));
	}
	@Override
	public void onInitialize() {
		ModItems.register();

		ModFluids.register();

		ModBlocks.register();

		ModBlockEntities.register();

		ModItemGroups.register();

		ModEntities.register();

		ModArmorMaterials.register();

		ModEnchantments.register();

		ModEffects.register();

		ModScreenHandlers.register();
	}
}
