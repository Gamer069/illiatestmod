package net.illia.illiatestmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.projectile.ThrowableRuby;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
	public static final EntityType<IlliaCubeEntity> ILLIA_CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier(IlliaTestMod.MOD_ID, "illia_cube"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IlliaCubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
	public static final EntityType<ThrowableRuby> THROWABLE_RUBY = Registry.register(Registry.ENTITY_TYPE, new Identifier(IlliaTestMod.MOD_ID, "throwable_ruby"), FabricEntityTypeBuilder.<ThrowableRuby>create(SpawnGroup.MISC, ThrowableRuby::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
	public static void register() {
		FabricDefaultAttributeRegistry.register(ModEntities.ILLIA_CUBE, IlliaCubeEntity.createMobAttributes());
	}
}
