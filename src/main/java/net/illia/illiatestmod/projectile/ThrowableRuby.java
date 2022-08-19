package net.illia.illiatestmod.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.illia.illiatestmod.entity.ModEntities;
import net.illia.illiatestmod.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrowableRuby extends ThrownItemEntity {
	public ThrowableRuby(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}
	public ThrowableRuby(World world, LivingEntity owner) {
		super(ModEntities.THROWABLE_RUBY, owner, world);
	}
	public ThrowableRuby(World world, double x, double y, double z) {
		super(ModEntities.THROWABLE_RUBY, x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ModItems.THROWABLE_RUBY;
	}
	@Environment(EnvType.CLIENT)
	private ParticleEffect getParticleParameters() {
		ItemStack itemStack = this.getItem();
		return (ParticleEffect) (itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
	}
	@Environment(EnvType.CLIENT)
	public void handleStatus(byte status) {
		if (status == 3) {
			ParticleEffect effect = this.getParticleParameters();
			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(effect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}
	protected void onEntityHit(EntityHitResult result) {
		super.onEntityHit(result);
		Entity entity = result.getEntity();
		int i = entity instanceof BlazeEntity ? 3 : 0;
		entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (byte)3);
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 255)));
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.DARKNESS, 20 * 3, 255)));
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient()) {
			this.world.sendEntityStatus(this, (byte)3);
			this.kill();
		}
	}
}
