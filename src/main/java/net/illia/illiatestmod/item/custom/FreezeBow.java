package net.illia.illiatestmod.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.function.Predicate;

import static net.minecraft.item.Items.SPECTRAL_ARROW;

public class FreezeBow extends RangedWeaponItem implements Vanishable {
	public static final int RANGE = 20;
	public FreezeBow(Settings settings) {
		super(settings);
	}

	@Override
	public Predicate<ItemStack> getProjectiles() {
		return BOW_PROJECTILES;
	}

	@Override
	public int getRange() {
		return RANGE;
	}

	@Override
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
		boolean bl2;
		int i;
		float f;
		if (!(user instanceof PlayerEntity)) {
			return;
		}
		PlayerEntity player = (PlayerEntity)user;
		boolean bl = player.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
		ItemStack itemStack = player.getArrowType(stack);
		if (itemStack.isEmpty() && !bl) {
			return;
		}
		if (itemStack.isEmpty()) {
			itemStack = new ItemStack(Items.ARROW);
		}
		if ((double)(f = FreezeBow.getPullProgress(i = this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
			return;
		}
		boolean bl3 = bl2 = bl && itemStack.isOf(Items.ARROW);
		if (!world.isClient) {
			int k;
			int j;
			ArrowItem arrowItem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
			PersistentProjectileEntity projectile = arrowItem.createArrow(world, itemStack, player);
			projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, f * 3.0f, 1.0f);
			if (f == 1.0f) {
				projectile.setCritical(true);
			}
			if ((j = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
				projectile.setDamage(projectile.getDamage() + (double)j * 0.5 + 0.5);
			}
			if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
				projectile.setPunch(k);
			}
			if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
				player.setOnFireFor(120);
			}
			stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
			if (bl2 || player.getAbilities().creativeMode && (itemStack.isOf(SPECTRAL_ARROW) || itemStack.isOf(Items.TIPPED_ARROW))) {
				projectile.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
			}
			world.spawnEntity(projectile);
		}
		world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
		if (!bl2 && !player.getAbilities().creativeMode) {
			itemStack.decrement(1);
			if (itemStack.isEmpty()) {
				player.getInventory().removeOne(itemStack);
			}
		}
		player.incrementStat(Stats.USED.getOrCreateStat(this));
	}
	public static float getPullProgress(int useTicks) {
		float f = (float)useTicks / 20.0f;
		if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
			f = 1.0f;
		}
		return f;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 7200000;
	}
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		boolean bl;
		ItemStack itemStack = user.getStackInHand(hand);
		boolean bl2 = bl = !user.getArrowType(itemStack).isEmpty();
		if (user.getAbilities().creativeMode || bl) {
			user.setCurrentHand(hand);
			return TypedActionResult.consume(itemStack);
		}
		return TypedActionResult.fail(itemStack);
	}
}
