package net.illia.illiatestmod;

import net.fabricmc.api.ModInitializer;
import net.illia.illiatestmod.armor.materials.ModArmorMaterials;
import net.illia.illiatestmod.block.ModBlockEntities;
import net.illia.illiatestmod.block.ModBlocks;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.fluid.ModFluids;
import net.illia.illiatestmod.items.ModItemGroups;
import net.illia.illiatestmod.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IlliaTestMod implements ModInitializer {
	public static final String MOD_ID = "illiatestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(IlliaTestMod.MOD_ID);
	@Override
	public void onInitialize() {
		ModItems.register();

		ModFluids.register();

		ModBlocks.register();

		ModBlockEntities.register();

		ModItemGroups.register();

		ModEntities.register();

		ModArmorMaterials.register();

		LOGGER.info("HELLO, YOU STUPID LOG READER");
	}
}
