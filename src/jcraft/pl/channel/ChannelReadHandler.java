package jcraft.pl.channel;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import jcraft.pl.PacketListenerPlugin;
import jcraft.pl.PacketType;
import jcraft.pl.event.PacketPlayInEvent;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;

public class ChannelReadHandler extends ByteToMessageDecoder {

    private final Player player;
    private final PacketListenerPlugin plugin;

    public ChannelReadHandler(PacketListenerPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandler, Object packetObject) throws Exception {
        if (NMSUtils.isPacket(packetObject)) {
            final PacketType type = PacketType.getTypeByClass(packetObject.getClass());

            if (type != null && this.plugin.isRegisteredPacketType(type)) {
                final PacketPlayInEvent event = new PacketPlayInEvent(packetObject, type, player);

                this.plugin.getServer().getPluginManager().callEvent(event);

                if (event.isCancelled()) {
                    return;
                }
            }
        }

        super.channelRead(channelHandler, packetObject);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandler, ByteBuf byteBuf, List<Object> objects) throws Exception {
        final Object packetObject = objects.get(0);

        if (NMSUtils.isPacket(packetObject)) {
            final PacketType type = PacketType.getTypeByClass(packetObject.getClass());

            if (type != null && this.plugin.isRegisteredPacketType(type)) {
                final PacketPlayInEvent event = new PacketPlayInEvent(packetObject, type, player);

                this.plugin.getServer().getPluginManager().callEvent(event);

                if (event.isCancelled()) {
                    return;
                }
            }
        }

        super.callDecode(channelHandler, byteBuf, objects);
    }

}