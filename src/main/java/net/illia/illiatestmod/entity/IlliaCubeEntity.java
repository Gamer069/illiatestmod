package net.illia.illiatestmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class IlliaCubeEntity extends PathAwareEntity {
	public IlliaCubeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}
}
