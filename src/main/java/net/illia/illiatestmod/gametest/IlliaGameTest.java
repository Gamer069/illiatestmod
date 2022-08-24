package net.illia.illiatestmod.gametest;

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest;
import net.minecraft.block.Blocks;
import net.minecraft.test.TestContext;
import net.minecraft.util.math.BlockPos;

import java.lang.reflect.Method;

public class IlliaGameTest implements FabricGameTest {
	@Override
	public void invokeTestMethod(TestContext context, Method method) {
		beforeEach(context);
		FabricGameTest.super.invokeTestMethod(context, method);
		afterEach(context);
	}
	private void beforeEach(TestContext context) {
		System.out.println("beforeEach Has Been Called");
		context.setBlockState(0, 5, 0, Blocks.NETHERITE_BLOCK);
	}
	private void afterEach(TestContext context) {
		context.addInstantFinalTask(() -> {
			context.checkBlock(new BlockPos(0, 5, 0), (block) -> block == Blocks.NETHERITE_BLOCK, "Expect A Netherite Block :)");
		});
	}
}
