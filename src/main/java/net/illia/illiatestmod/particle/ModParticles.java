package net.illia.illiatestmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
	public static final DefaultParticleType PURPLE_FLAME = FabricParticleTypes.simple();
	public static void register() {
		Registry.register(Registry.PARTICLE_TYPE, new Identifier(IlliaTestMod.MOD_ID, "purple_flame"), ModParticles.PURPLE_FLAME);
	}
}
