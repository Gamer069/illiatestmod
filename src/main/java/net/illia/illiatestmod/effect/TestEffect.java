package net.illia.illiatestmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class TestEffect extends StatusEffect {
	protected TestEffect() {
		super(StatusEffectCategory.BENEFICIAL, 0x98D982);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).addExperience(1 << amplifier);
				((PlayerEntity) entity).getItemCooldownManager().set(entity.getMainHandStack().getItem(), 0);
				((PlayerEntity) entity).getItemCooldownManager().set(entity.getOffHandStack().getItem(), 0);
		}
	}

	@Override
	public boolean isInstant() {
		return true;
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}

	@Override
	public StatusEffectCategory getCategory() {
		return StatusEffectCategory.BENEFICIAL;
	}

	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).setInvulnerable(true);
			((PlayerEntity) entity).setAbsorptionAmount(40);
		}
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).setInvulnerable(false);
			((PlayerEntity) entity).setAbsorptionAmount(0);
		}
	}

}
