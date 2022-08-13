package net.illia.illiatestmod;

import net.fabricmc.api.ClientModInitializer;

public class IlliaTestModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		System.out.println("The Client Has Loaded, This Is The IlliaTestModClient Class");
		IlliaTestMod.LOGGER.debug("Hello You LOGGER Idiot");
	}
}
