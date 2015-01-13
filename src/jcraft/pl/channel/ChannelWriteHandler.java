package jcraft.pl.channel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import jcraft.pl.PacketListenerPlugin;
import jcraft.pl.PacketType;
import jcraft.pl.event.PacketPlayOutEvent;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;

public class ChannelWriteHandler extends ChannelOutboundHandlerAdapter {

    private final Player player;
    private final PacketListenerPlugin plugin;

    public ChannelWriteHandler(PacketListenerPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public void write(ChannelHandlerContext channelHandler, Object packetObject, ChannelPromise promise) throws Exception {
        if (NMSUtils.isPacket(packetObject)) {
            final PacketType type = PacketType.getTypeByClass(packetObject.getClass());

            if (type != null && this.plugin.isRegisteredPacketType(type)) {
                final PacketPlayOutEvent event = new PacketPlayOutEvent(packetObject, type, player);

                this.plugin.getServer().getPluginManager().callEvent(event);

                if (event.isCancelled()) {
                    return;
                }
            }
        }

        super.write(channelHandler, packetObject, promise);
    }

}
