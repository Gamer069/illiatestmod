package net.illia.illiatestmod.effect;

import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
	public static final StatusEffect TEST_EFFECT = new TestEffect();
	public static void register() {
		Registry.register(Registry.STATUS_EFFECT, new Identifier(IlliaTestMod.MOD_ID, "test_effect"), ModEffects.TEST_EFFECT);
	}
}
