package net.illia.illiatestmod.entity;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.IlliaTestModClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class IlliaCubeEntityRenderer extends MobEntityRenderer<IlliaCubeEntity, IlliaCubeEntityModel> {
	public IlliaCubeEntityRenderer(EntityRendererFactory.Context context, EntityModel entityModel, float f) {
		super(context, new IlliaCubeEntityModel(context.getPart(IlliaTestModClient.MODEL_CUBE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(Entity entity) {
		return new Identifier(IlliaTestMod.MOD_ID, "textures/entity/cube/illia_cube.png");
	}
}
