package net.illia.illiatestmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class TestEffect extends StatusEffect {
	protected TestEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).addExperience(1 << amplifier);
		}
	}

	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).requestRespawn();
			entity.setMovementSpeed(4);
			entity.setInvulnerable(true);
		}
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).setInvulnerable(false);
			entity.setMovementSpeed(1);
		}
	}

	@Override
	public boolean isInstant() {
		return true;
	}
}
