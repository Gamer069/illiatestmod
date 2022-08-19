package net.illia.illiatestmod;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.NotNull;

public class ModScreenHandlers {
	@NotNull
	public static ScreenHandlerType<DiamondChestScreenHandler> DIAMOND_CHEST_SCREEN_HANDLER;
	public static void register() {
		DIAMOND_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(IlliaTestMod.DIAMOND_CHEST_IDENTIFIER, DiamondChestScreenHandler::new);
	}
}
