package jcraft.pl.channel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import jcraft.pl.event.PacketEventHandler;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class ChannelWriteHandler extends ChannelOutboundHandlerAdapter {

    private final Player player;

    public ChannelWriteHandler(Player player) {
        this.player = player;
    }

    @Override
    public void write(ChannelHandlerContext channelHandler, Object packetObject, ChannelPromise promise) throws Exception {
        if (NMSUtils.isPacket(packetObject)) {
            final Cancellable event = PacketEventHandler.onPacketPlayOut(this.player, packetObject);

            if (event.isCancelled()) {
                return;
            }
        }

        super.write(channelHandler, packetObject, promise);
    }

}
