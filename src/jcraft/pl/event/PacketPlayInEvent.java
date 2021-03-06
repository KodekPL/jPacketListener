package jcraft.pl.event;

import java.lang.reflect.Field;

import jcraft.pl.PacketType;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PacketPlayInEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final PacketType type;
    private Object packet;

    private boolean isCancelled;

    public PacketPlayInEvent(Object packet, PacketType type, Player player) {
        this.player = player;
        this.type = type;
        this.packet = packet;
    }

    public Player getPlayer() {
        return this.player;
    }

    public PacketType getPacketType() {
        return this.type;
    }

    public void setPacketValue(String fieldName, Object value) {
        try {
            final Field field = this.packet.getClass().getDeclaredField(fieldName);

            field.setAccessible(true);

            field.set(this.packet, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getPacketValue(String fieldName) {
        Object value = null;

        try {
            final Field field = this.packet.getClass().getDeclaredField(fieldName);

            field.setAccessible(true);

            value = field.get(this.packet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public void setPacket(Object packet) {
        this.packet = packet;
    }

    public Object getPacket() {
        return this.packet;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
