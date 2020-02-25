package neominecraftism.neominecraftism.subscriber;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class WorldHandler implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		UUID uuid = event.getPlayer().getUniqueId();
		NeoMinecraftism.getInstance().getStorageTracker().loadOrCreatePlayerEntry(uuid);
	}
	
	public void onPlayerLeave(PlayerQuitEvent event) {
		UUID uuid = event.getPlayer().getUniqueId();
		NeoMinecraftism.getInstance().getStorageTracker().dumpPlayer(uuid);
	}
}
