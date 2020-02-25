package neominecraftism.neominecraftism.subscriber;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import neominecraftism.neominecraftism.spell.SpellFactory;

public class SpellHandler implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRightClick(PlayerInteractEvent event) {
		
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSpellUse(PlayerDropItemEvent event) {
		event.getPlayer().getInventory().addItem(SpellFactory.createSpellStack("mass_healing_spell"));
	}
}
