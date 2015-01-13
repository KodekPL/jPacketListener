package jcraft.pl;

import io.netty.channel.Channel;

import java.util.NoSuchElementException;

import jcraft.pl.channel.ChannelReadHandler;
import jcraft.pl.channel.ChannelWriteHandler;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;

public class ChannelInjector {

    public void addChannel(Player player) {
        final Channel channel = NMSUtils.getNetworkManagerChannel(player);

        try {
            channel.pipeline().addBefore("packet_handler", "packet_listener_in", new ChannelReadHandler(player));
        } catch (IllegalArgumentException e) {

        }

        try {
            channel.pipeline().addBefore("packet_handler", "packet_listener_out", new ChannelWriteHandler(player));
        } catch (IllegalArgumentException e) {

        }
    }

    public void removeChannel(Player player) {
        final Channel channel = NMSUtils.getNetworkManagerChannel(player);

        try {
            channel.pipeline().remove("packet_listener_in");
        } catch (NoSuchElementException e) {

        }

        try {
            channel.pipeline().remove("packet_listener_out");
        } catch (NoSuchElementException e) {

        }
    }

}