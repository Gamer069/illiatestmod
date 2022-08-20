package net.illia.illiatestmod.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class IlliaCubeEntity extends PathAwareEntity {
	private static final TrackedData<Integer> TRACKED_ENTITY_ID_1 = DataTracker.registerData(IlliaCubeEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> TRACKED_ENTITY_ID_2 = DataTracker.registerData(IlliaCubeEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> TRACKED_ENTITY_ID_3 = DataTracker.registerData(IlliaCubeEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final List<TrackedData<Integer>> TRACKED_ENTITY_IDS = ImmutableList.of(TRACKED_ENTITY_ID_1, TRACKED_ENTITY_ID_2, TRACKED_ENTITY_ID_3);
	private final float[] sideHeadPitches = new float[2];
	private final float[] sideHeadYaws = new float[2];
	private final float[] prevSideHeadPitches = new float[2];
	private final float[] prevSideHeadYaws = new float[2];
	private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE = entity -> entity.getGroup() != EntityGroup.UNDEAD && entity.isMobOrPlayer();
	private static final TargetPredicate HEAD_TARGET_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(20.0).setPredicate(CAN_ATTACK_PREDICATE);
	private final ServerBossBar bossBar = (ServerBossBar) new ServerBossBar(this.getDisplayName(), Color.GREEN, Style.PROGRESS).setDarkenSky(true);

	public IlliaCubeEntity(EntityType<? extends IlliaCubeEntity> entityType, World world) {
		super((EntityType<? extends IlliaCubeEntity>) entityType, world);
		this.moveControl = new MoveControl(this);
		this.setHealth(this.getMaxHealth());
		this.experiencePoints = 100;
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		EntityNavigation navigation = new MobNavigation(this, world);
		navigation.setCanSwim(true);
		return navigation;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(1, new RevengeGoal(this, new Class[0]));
		this.goalSelector.add(2, new AvoidSunlightGoal(this));
		this.goalSelector.add(3, new ActiveTargetGoal<LivingEntity>(this, LivingEntity.class, true));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IlliaCubeEntity.TRACKED_ENTITY_ID_1, 0);
		this.dataTracker.startTracking(IlliaCubeEntity.TRACKED_ENTITY_ID_2, 0);
		this.dataTracker.startTracking(IlliaCubeEntity.TRACKED_ENTITY_ID_3, 0);
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);
		this.bossBar.setName(this.getCustomName());
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_SLIME_HURT_SMALL;
	}
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_DEATH_SMALL;
	}

	@Override
	public void tickMovement() {
		int j;
		int i;
		Entity entity;
		Vec3d vec3d = this.getVelocity().multiply(1.0, 0.6, 1.0);
		if (!this.world.isClient && this.getTrackedEntityId(0) > 0 && (entity = this.world.getEntityById(this.getTrackedEntityId(0))) != null) {
			double d = vec3d.y;
			if (this.getY() < entity.getY() || !this.shouldRenderOverlay() && this.getY() < entity.getY() + 5.0) {
				d = Math.max(0.0, d);
				d += 0.3 - d * (double)0.6f;
			}
			vec3d = new Vec3d(vec3d.x, d, vec3d.z);
			Vec3d vec3d2 = new Vec3d(entity.getX() - this.getX(), 0.0, entity.getZ() - this.getZ());
			if (vec3d2.horizontalLengthSquared() > 9.0) {
				Vec3d vec3d3 = vec3d2.normalize();
				vec3d = vec3d.add(vec3d3.x * 0.3 - vec3d.x * 0.6, 0.0, vec3d3.z * 0.6);
			}
		}
		this.setVelocity(vec3d);
		if (vec3d.horizontalLengthSquared() > 0.05) {
			this.setYaw((float) MathHelper.atan2(vec3d.z, vec3d.x) * 57.295776f- 90.0f);
		}
		super.tickMovement();
		for (i = 0; i < 2; ++i) {
			this.prevSideHeadYaws[i] = this.sideHeadYaws[i];
			this.prevSideHeadPitches[i] = this.sideHeadPitches[i];
		}
		for (i = 0; i < 2; ++i) {
			int j2 = this.getTrackedEntityId(i + 1);
			Entity entity2 = null;
			if (j2 > 0) {
				entity2 = this.world.getEntityById(j2);
			}
			if (entity2 != null) {
				double e = this.getHeadX(i + 1);
				double f = this.getHeadY(i + 1);
				double g = this.getHeadZ(i + 1);
				double h = entity2.getX() - e;
				double k = entity2.getEyeY() - f;
				double l = entity2.getZ() - g;
				double m = Math.sqrt(h * h + l * l);
				float n = (float)(MathHelper.atan2(l, h) * 57.2957763671875) - 90.0f;
				float o = (float)(-(MathHelper.atan2(k, m) * 57.2957763671875));
				this.sideHeadPitches[i] = this.getNextAngle(this.sideHeadPitches[i], o, 40.0f);
				this.sideHeadYaws[i] = this.getNextAngle(this.sideHeadYaws[i], n, 10.0f);
				continue;
			}
			this.sideHeadYaws[i] = this.getNextAngle(this.sideHeadYaws[i], this.bodyYaw, 10.0f);
		}
		boolean bl = this.shouldRenderOverlay();
		for (j = 0; j < 3; ++j) {
			double p = this.getHeadX(j);
			double q = this.getHeadY(j);
			double r = this.getHeadZ(j);
			this.world.addParticle(ParticleTypes.SMOKE, p + this.random.nextGaussian() * (double)0.3f, q + this.random.nextGaussian() * (double)0.3f, r + this.random.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
			if (!bl || this.world.random.nextInt(4) != 0) continue;
			this.world.addParticle(ParticleTypes.ENTITY_EFFECT, p + this.random.nextGaussian() * (double)0.3f, q + this.random.nextGaussian() * (double)0.3f, r + this.random.nextGaussian() * (double)0.3f, 0.7f, 0.7f, 0.5);
		}
	}

	@Override
	protected void mobTick() {
		int j;
		int i = 0;
		super.mobTick();
		if ((j = this.getTrackedEntityId(i)) > 0) {
			LivingEntity livingEntity = (LivingEntity) this.world.getEntityById(j);
			if (livingEntity == null || !this.canTarget(livingEntity) || this.squaredDistanceTo(livingEntity) > 900.0 || !this.canSee(livingEntity)) {
				this.setTrackedEntityId(i, 0);
			}
			this.tryAttack(getTarget().getAttacker());
		}
		List<LivingEntity> list = this.world.getTargets(LivingEntity.class, HEAD_TARGET_PREDICATE, this, this.getBoundingBox().expand(20.0, 8.0, 20.0));
		if (list.isEmpty()) {
			LivingEntity livingEntity2 = list.get(this.random.nextInt(list.size()));
			this.setTrackedEntityId(i, livingEntity2.getId());
			if (this.getTarget() != null) {
				this.setTrackedEntityId(0, this.getTarget().getId());
			} else {
				this.setTrackedEntityId(0, 0);
			}
			this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}
	@Override
	public void onSpawnPacket(EntitySpawnS2CPacket packet) {
		this.bossBar.setPercent(0.0f);
		this.setHealth(this.getMaxHealth() / 3.0f);
	}
	@Override
	public void slowMovement(BlockState state, Vec3d multiplier) {
	}

	@Override
	public void onStartedTrackingBy(ServerPlayerEntity player) {
		super.onStartedTrackingBy(player);
		this.bossBar.addPlayer(player);
	}

	@Override
	public void onStoppedTrackingBy(ServerPlayerEntity player) {
		super.onStoppedTrackingBy(player);
		this.bossBar.removePlayer(player);
	}
	public double getHeadX(int headIndex) {
		if (headIndex <= 0) {
			return this.getX();
		}
		float f = (this.bodyYaw + (float)(180 * (headIndex - 1))) * ((float) Math.PI / 180);
		float g = MathHelper.cos(f);
		return this.getX() + (double)g * 1.3;
	}
	public double getHeadY(int headIndex) {
		if (headIndex <= 0) {
			return this.getY() + 3.0;
		}
		return this.getY() + 2.2;
	}
	public double getHeadZ(int headIndex) {
		if (headIndex <= 0) {
			return this.getZ();
		}
		float f = (this.bodyYaw + (float)(180 * (headIndex - 1))) * ((float)Math.PI / 180);
		float g = MathHelper.sin(f);
		return this.getZ() + (double)g * 1.3;
	}
	private float getNextAngle(float prevAngle, float desiredAngle, float maxDifference) {
		float f = MathHelper.wrapDegrees(desiredAngle - prevAngle);
		if (f > maxDifference) {
			f = maxDifference;
		}
		if (f < -maxDifference) {
			f = -maxDifference;
		}
		return prevAngle + f;
	}
	public int getTrackedEntityId(int headIndex) {
		return this.dataTracker.get(TRACKED_ENTITY_IDS.get(headIndex));
	}
	public boolean shouldRenderOverlay() {
		return this.getHealth() <= this.getMaxHealth() / 2.0f;
	}

	@Override
	protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
		super.dropEquipment(source, lootingMultiplier, allowDrops);
		ItemEntity itemEntity = this.dropItem(Items.SLIME_BLOCK);
		if (itemEntity != null) {
			itemEntity.setCovetedItem();
		}
	}

	@Override
	public void checkDespawn() {
		if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
			this.discard();
			return;
		}
		this.despawnCounter = 0;
	}

	@Override
	public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
		return false;
	}

	@Override
	public boolean addStatusEffect(StatusEffectInstance effect, @Nullable Entity source) {
		return false;
	}
	public float getHeadYaw(int headIndex) {
		return this.sideHeadYaws[headIndex];
	}
	public float getHeadPitch(int headIndex) {
		return this.sideHeadPitches[headIndex];
	}
	@Override
	public float getHealth() {
		return 200;
	}
	public static DefaultAttributeContainer.Builder createIlliaCubeAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0);
	}
	public void setTrackedEntityId(int headIndex, int id) {
		this.dataTracker.set(TRACKED_ENTITY_IDS.get(headIndex), id);
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.UNDEAD;
	}

	@Override
	protected boolean canStartRiding(Entity entity) {
		return false;
	}

	@Override
	public boolean canUsePortals() {
		return true;
	}

	@Override
	public boolean canHaveStatusEffect(StatusEffectInstance effect) {
		return true;
	}
	class DescendAtHalfHealthGoal
	extends Goal {
		public DescendAtHalfHealthGoal() {
			this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
		}

		@Override
		public boolean canStart() {
			return true;
		}

		@Override
		public boolean canStop() {
			return true;
		}
	}
}
