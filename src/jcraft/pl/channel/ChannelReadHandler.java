package jcraft.pl.channel;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import jcraft.pl.event.PacketEventHandler;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class ChannelReadHandler extends ByteToMessageDecoder {

    private final Player player;

    public ChannelReadHandler(Player player) {
        this.player = player;
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandler, Object packetObject) throws Exception {
        if (NMSUtils.isPacket(packetObject)) {
            final Cancellable event = PacketEventHandler.onPacketPlayIn(this.player, packetObject);

            if (event.isCancelled()) {
                return;
            }
        }

        super.channelRead(channelHandler, packetObject);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandler, ByteBuf byteBuf, List<Object> objects) throws Exception {
        final Object packetObject = objects.get(0);

        if (NMSUtils.isPacket(packetObject)) {
            final Cancellable event = PacketEventHandler.onPacketPlayOut(this.player, packetObject);

            if (event.isCancelled()) {
                return;
            }
        }

        super.callDecode(channelHandler, byteBuf, objects);
    }

}