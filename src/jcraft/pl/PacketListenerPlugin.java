package jcraft.pl;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketListenerPlugin extends JavaPlugin implements Listener {

    private ChannelInjector injector;

    public void onEnable() {
        injector = new ChannelInjector();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    public ChannelInjector getInjector() {
        return this.injector;
    }

}
