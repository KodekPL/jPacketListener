package jcraft.pl;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketListenerPlugin extends JavaPlugin implements Listener {

    private ChannelInjector injector;
    private Set<PacketType> registeredPacketTypes;

    public void onEnable() {
        injector = new ChannelInjector(this);
        registeredPacketTypes = new HashSet<PacketType>();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    public ChannelInjector getInjector() {
        return this.injector;
    }

    public void registerPacketType(PacketType type) {
        this.registeredPacketTypes.add(type);
    }

    public void unRegisterPacketType(PacketType type) {
        this.registeredPacketTypes.remove(type);
    }

    public boolean isRegisteredPacketType(PacketType type) {
        return this.registeredPacketTypes.contains(type);
    }

}
