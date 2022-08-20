package net.illia.illiatestmod;

import net.fabricmc.api.DedicatedServerModInitializer;

public class IlliaTestModServer implements DedicatedServerModInitializer {
	public boolean serverFailInit = onServerFailInit();
	@Override
	public void onInitializeServer() {
		System.out.println("The Server Side Is Ready");
		IlliaTestMod.LOGGER.debug("The Server Side Is Ready");
	}
	public boolean onServerFailInit() {
		if (serverFailInit) {
			System.err.println("The Server Side Timed Out");
			IlliaTestMod.LOGGER.error("The Server Side Timed Out");
			throw new RuntimeException("The Server Side Timed Out");
		}
		return true;
	}
}
