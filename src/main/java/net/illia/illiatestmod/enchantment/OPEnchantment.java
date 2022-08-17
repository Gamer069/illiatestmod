package net.illia.illiatestmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import java.util.Map;

public class OPEnchantment extends Enchantment {
	@Override
	public Map<EquipmentSlot, ItemStack> getEquipment(LivingEntity entity) {
		return super.getEquipment(entity);
	}

	@Override
	public boolean isTreasure() {
		return super.isTreasure();
	}

	@Override
	public int getMaxPower(int level) {
		return 5;
	}

	public OPEnchantment() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}
	@Override
	public int getMinPower(int level) {
		return 1;
	}

	@Override
	public int getMinLevel() {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
		if (user instanceof LivingEntity) {
			((LivingEntity) attacker).setInvulnerable(true);
			((LivingEntity) attacker).animateDamage();
			((LivingEntity) attacker).setMovementSpeed(3);
		}
		super.onUserDamaged(user, attacker, level);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			((LivingEntity) target).setMovementSpeed(((LivingEntity) target).getMovementSpeed() - 0.5F);
			target.setCustomName(Text.of("LOSER"));
			((LivingEntity) target).setInvulnerable(false);
			((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20, 2, false, false, false));
		}
		super.onTargetDamaged(user, target, level);
	}
}
