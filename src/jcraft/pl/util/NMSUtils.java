package jcraft.pl.util;

import io.netty.channel.Channel;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.NetworkManager;
import net.minecraft.server.v1_8_R1.Packet;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSUtils {

    public static boolean isPacket(Object object) {
        return object instanceof Packet;
    }

    public static Channel getNetworkManagerChannel(Player player) {
        final EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        final PlayerConnection playerConnection = entityPlayer.playerConnection;

        Channel channel = null;

        try {
            final Field field = NetworkManager.class.getDeclaredField("i");

            field.setAccessible(true);

            channel = (Channel) field.get(playerConnection.networkManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return channel;
    }

}
