package net.illia.illiatestmod.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
	public static final Biome ILLIA_LAND = createIlliaLand();
	public static Biome createIlliaLand() {
		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		GenerationSettings.Builder genBuilder = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
		DefaultBiomeFeatures.addAmethystGeodes(genBuilder);
		DefaultBiomeFeatures.addAncientDebris(genBuilder);
		DefaultBiomeFeatures.addDesertFeatures(genBuilder);
		DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100, false);
		DefaultBiomeFeatures.addForestTrees(genBuilder);
		DefaultBiomeFeatures.addFrozenTopLayer(genBuilder);
		DefaultBiomeFeatures.addEmeraldOre(genBuilder);
		DefaultBiomeFeatures.addMangroveSwampFeatures(genBuilder);
		DefaultBiomeFeatures.addDefaultGrass(genBuilder);
		DefaultBiomeFeatures.addAmethystGeodes(genBuilder);
		DefaultBiomeFeatures.addExtraGoldOre(genBuilder);
		DefaultBiomeFeatures.addDefaultOres(genBuilder, true);
		DefaultBiomeFeatures.addSwampFeatures(genBuilder);
		DefaultBiomeFeatures.addMelons(genBuilder);
		DefaultBiomeFeatures.addPlainsFeatures(genBuilder);
		DefaultBiomeFeatures.addMineables(genBuilder);
		DefaultBiomeFeatures.addNetherMineables(genBuilder);

		return (new Biome.Builder()).precipitation(Precipitation.SNOW).downfall(1).temperature(1).spawnSettings(spawnSettings.build()).effects(new BiomeEffects.Builder().skyColor(4196275).grassColor(4196275).fogColor(6950317).waterColor(16711680).waterFogColor(16711680).build()).spawnSettings(spawnSettings.build()).generationSettings(genBuilder.build()).build();
	}
	public static void register() {
		ModBiomes.createIlliaLand();
	}
}
