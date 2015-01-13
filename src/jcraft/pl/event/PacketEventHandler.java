package jcraft.pl.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class PacketEventHandler {

    public static Cancellable onPacketPlayIn(Player player, Object packet) {
        final PacketPlayInEvent event = new PacketPlayInEvent(packet, player);

        Bukkit.getPluginManager().callEvent(event);

        return event;
    }

    public static Cancellable onPacketPlayOut(Player player, Object packet) {
        final PacketPlayOutEvent event = new PacketPlayOutEvent(packet, player);

        Bukkit.getPluginManager().callEvent(event);

        return event;
    }

}
