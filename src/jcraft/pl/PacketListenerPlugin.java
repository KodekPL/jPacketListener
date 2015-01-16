package jcraft.pl;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketListenerPlugin extends JavaPlugin implements Listener {

    private Thread injectorThread;
    private ChannelInjector injector;
    private Set<PacketType> registeredPacketTypes = new HashSet<PacketType>();

    public void onEnable() {
        injector = new ChannelInjector(this);
        injectorThread = new Thread(injector);
        injectorThread.start();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    public void onDisable() {
        injector.killInjector();
        injector.notifyInjector();

        try {
            injectorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
