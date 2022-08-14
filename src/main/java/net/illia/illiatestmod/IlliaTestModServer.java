package net.illia.illiatestmod;

import net.fabricmc.api.DedicatedServerModInitializer;

public class IlliaTestModServer implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		System.out.println("The Server Side Is Ready");
		IlliaTestMod.LOGGER.debug("The Server Side Is Ready");
	}
}
