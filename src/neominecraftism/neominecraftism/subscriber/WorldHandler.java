package neominecraftism.neominecraftism.subscriber;

import java.util.UUID;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.profession.Professions;

public class WorldHandler implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		UUID uuid = event.getPlayer().getUniqueId();
		NeoMinecraftism.getInstance().getStorageTracker().loadOrCreatePlayerEntry(uuid);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeave(PlayerQuitEvent event) {
		UUID uuid = event.getPlayer().getUniqueId();
		NeoMinecraftism.getInstance().getStorageTracker().dumpPlayer(uuid);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerTalk(PlayerInteractEntityEvent event) {
		if (event.getRightClicked() instanceof Villager && ProfessionHelper.hasProfession(event.getPlayer(), Professions.CIVILIAN)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage("无法与村民交易，因为你不是城镇居民！");
		}
		
	}
}
