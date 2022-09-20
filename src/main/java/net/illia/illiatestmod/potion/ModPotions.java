package net.illia.illiatestmod.potion;

import net.illia.illiatestmod.IlliaTestMod;
import net.illia.illiatestmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.LingeringPotionItem;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
	public static Potion TEST_POTION;
	public static SplashPotionItem SPLASH_TEST_POTION;
	public static LingeringPotionItem LINGERING_TEST_POTION;

	public static Potion register(String name) {
		return Registry.register(Registry.POTION, new Identifier(IlliaTestMod.MOD_ID, name), new Potion(new StatusEffectInstance(ModEffects.TEST_EFFECT, 10000, 15)));
	}
	public static void register() {
		TEST_POTION = register("test_potion");
	}
}
