package net.illia.illiatestmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
	public static final EntityType<IlliaCubeEntity> ILLIA_CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier(IlliaTestMod.MOD_ID, "illia_cube"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IlliaCubeEntity::new).dimensions(EntityDimensions.changing(0.75f, 0.75f)).build());
	public static void register() {
		FabricDefaultAttributeRegistry.register(ModEntities.ILLIA_CUBE, IlliaCubeEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ILLIA_CUBE, IlliaCubeEntity.createIlliaCubeAttributes());
	}
}
