package net.illia.illiatestmod.items.custom;

import net.illia.illiatestmod.projectile.ThrowableRuby;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableRubyItem extends Item {
	public ThrowableRubyItem(Settings settings) {
		super(settings);
	}
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);
		user.getItemCooldownManager().set(this, 5);
		if (!world.isClient) {
			ThrowableRuby throwableRubyEntity = new ThrowableRuby(world, user);
			throwableRubyEntity.setItem(itemStack);
			throwableRubyEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
			world.spawnEntity(throwableRubyEntity);
		}
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.decrement(1);
		}
		return TypedActionResult.success(itemStack, world.isClient());
	}
}
