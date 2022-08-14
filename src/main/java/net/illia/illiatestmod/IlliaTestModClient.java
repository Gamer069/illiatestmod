package net.illia.illiatestmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class IlliaTestModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("The Client Has Loaded, This Is The IlliaTestModClient Class");
		IlliaTestMod.LOGGER.debug("Hello You LOGGER Idiot");
		FluidRenderHandlerRegistry.INSTANCE.register(IlliaTestMod.STILL_MELTED_RUBY, IlliaTestMod.FLOWING_MELTED_RUBY, new SimpleFluidRenderHandler(new Identifier("minecraft:block/water_still"), new Identifier("minecraft:block/water_flow"), 0xA1E255D0));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), IlliaTestMod.STILL_MELTED_RUBY, IlliaTestMod.FLOWING_MELTED_RUBY);
	}
}
