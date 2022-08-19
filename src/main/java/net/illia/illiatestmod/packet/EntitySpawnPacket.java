package net.illia.illiatestmod.packet;

import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

public class EntitySpawnPacket {
	public static Packet<?> create(Entity e, Identifier packetID) {
		if (e.world.isClient)throw new IllegalStateException("SpawnPacketUtil.create called on the logical client");
		PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
		buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(e.getType()));
		buf.writeUuid(e.getUuid());
		buf.writeVarInt(e.getId());

		PacketBufUtil.writeVec3d(buf, e.getPos());
		PacketBufUtil.writeAngle(buf, e.getPitch());
		PacketBufUtil.writeAngle(buf, e.getYaw());
		return ServerPlayNetworking.createS2CPacket(packetID, buf);
	}
	public static final class PacketBufUtil {
		public static byte packAngle(float angle) {
			return (byte) MathHelper.floor(angle * 256 / 360);
		}
		public static float unpackAngle(byte angleByte) {
			return (angleByte * 360) / 256f;
		}
		public static void writeAngle(PacketByteBuf buf, float angle) {
			buf.writeByte(packAngle(angle));
		}
		public static float readAngle(PacketByteBuf buf) {
			return unpackAngle(buf.readByte());
		}
		public static void writeVec3d(PacketByteBuf buf, Vec3d vec3d) {
			buf.writeDouble(vec3d.x);
			buf.writeDouble(vec3d.y);
			buf.writeDouble(vec3d.z);
		}
		public static Vec3d readVec3d(PacketByteBuf buf) {
			double x = buf.readDouble();
			double y = buf.readDouble();
			double z = buf.readDouble();
			return new Vec3d(x, y, z);
		}
	}
}
