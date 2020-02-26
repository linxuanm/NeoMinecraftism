package neominecraftism.neominecraftism.subscriber;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpg.Weapons;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellFactory;
import neominecraftism.neominecraftism.util.NBTHelper;

public class SpellHandler implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRightClick(PlayerInteractEvent event) {
		if (!event.hasItem()) return;
		
		ItemStack stack = event.getItem();
		if (NBTHelper.hasTag(stack, "spell_id", PersistentDataType.STRING)) {
			event.setCancelled(true);
		}
		
		if (!NBTHelper.isItemDisabled(event.getItem())) {
			NBTHelper.getTag(stack, "spell_id", PersistentDataType.STRING).ifPresent(name -> {
				ISpell spell = NeoMinecraftism.getInstance().getRegistryHandler().get(ISpell.class, name);
				if (spell.canUse(event.getPlayer(), event.getClickedBlock())) {
					spell.onUse(event.getPlayer(), event.getClickedBlock());
					NBTHelper.disableItem(stack);
					stack.setType(Material.BARRIER);
					Bukkit.getScheduler().runTaskLater(NeoMinecraftism.getInstance(), () -> {
						NBTHelper.enableItem(stack);
						stack.setType(spell.getRepresentation());
					}, spell.getCoolDown());
					
				}
			});
		} 
	}
	

	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().forEach(stack -> {
			if (stack != null) {
				if (NBTHelper.isItemDisabled(stack)) {
					NBTHelper.enableItem(stack);
				}
			}
		});
	}
}
