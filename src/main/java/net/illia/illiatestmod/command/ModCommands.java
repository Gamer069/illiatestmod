package net.illia.illiatestmod.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.illia.illiatestmod.IlliaTestMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;


public class ModCommands {
	public static void register() {
		CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> dispatcher.register(literal("illiatest")
			.then(literal("message").executes(context -> {
				context.getSource().sendMessage(Text.of("Here Is Your Message!"));
				return 1;
			}))
			.executes(context -> {
			context.getSource().sendMessage(Text.literal("Test Has Been Passed"));
			return 1;
		}))));
		CommandRegistrationCallback.EVENT.register((((dispatcher, registryAccess, environment) -> dispatcher.register(literal("god")
			.executes(context -> {
				PlayerEntity player = context.getSource().getPlayer();
				if (player.isInvulnerable()) {
					player.setInvulnerable(false);
					player.sendMessage(Text.literal("You Have Disabled God Mode"), false);
					IlliaTestMod.LOGGER.warn(player.getDisplayName() + " Has Disabled God Mode");
				} else {
					player.setInvulnerable(true);
					player.sendMessage(Text.literal("You Have Enabled God Mode"), false);
					IlliaTestMod.LOGGER.warn(player.getDisplayName() + " Has Enabled Fly Mode");
				}
				return 1;
			})))));
	}
}
