package net.illia.illiatestmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.illia.illiatestmod.entity.IlliaCubeEntityRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IlliaTestModClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier(IlliaTestMod.MOD_ID, "illia_cube"), "main");
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(IlliaTestMod.ILLIA_CUBE, (context) -> {
			return new IlliaCubeEntityRenderer(context);
		});
		EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, IlliaCubeEntityModel::getTexturedModelData);
		System.out.println("The Client Has Loaded, This Is The IlliaTestModClient Class");
		IlliaTestMod.LOGGER.debug("Hello You LOGGER Idiot");
		FluidRenderHandlerRegistry.INSTANCE.register(IlliaTestMod.STILL_MELTED_RUBY, IlliaTestMod.FLOWING_MELTED_RUBY, new SimpleFluidRenderHandler(new Identifier("minecraft:block/water_still"), new Identifier("minecraft:block/water_flow"), 0xA1E255D0));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), IlliaTestMod.STILL_MELTED_RUBY, IlliaTestMod.FLOWING_MELTED_RUBY);
	}
}
