package jcraft.pl;

import io.netty.channel.Channel;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import jcraft.pl.channel.ChannelReadHandler;
import jcraft.pl.channel.ChannelWriteHandler;
import jcraft.pl.util.NMSUtils;

import org.bukkit.entity.Player;

public class ChannelInjector implements Runnable {

    private final PacketListenerPlugin plugin;

    private final Queue<Player> addQueue = new LinkedBlockingQueue<Player>();
    private final Queue<Player> removeQueue = new LinkedBlockingQueue<Player>();

    private boolean killRunnable = false;

    public ChannelInjector(PacketListenerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        while (true) {
            if (addQueue.isEmpty() && removeQueue.isEmpty() && !killRunnable) {
                this.waitInjector();
                continue;
            }

            if (!addQueue.isEmpty()) {
                addChannel(addQueue.poll());
            }

            if (!removeQueue.isEmpty()) {
                removeChannel(removeQueue.poll());
            }

            if (killRunnable) {
                return;
            }
        }
    }

    public synchronized void waitInjector() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyInjector() {
        this.notifyAll();
    }

    public void killInjector() {
        this.killRunnable = true;
    }

    public void queueAddChannel(Player player) {
        addQueue.add(player);

        notifyInjector();
    }

    private void addChannel(Player player) {
        final Channel channel = NMSUtils.getNetworkManagerChannel(player);

        try {
            channel.pipeline().addBefore("packet_handler", "packet_listener_in", new ChannelReadHandler(this.plugin, player));
        } catch (IllegalArgumentException e) {

        }

        try {
            channel.pipeline().addBefore("packet_handler", "packet_listener_out", new ChannelWriteHandler(this.plugin, player));
        } catch (IllegalArgumentException e) {

        }
    }

    public void queueRemoveChannel(Player player) {
        removeQueue.add(player);

        notifyInjector();
    }

    private void removeChannel(Player player) {
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
