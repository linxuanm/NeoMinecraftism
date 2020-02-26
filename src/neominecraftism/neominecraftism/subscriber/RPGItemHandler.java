package neominecraftism.neominecraftism.subscriber;

import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.util.NBTHelper;

public class RPGItemHandler  implements Listener{

	public static void init(Server server) {
		new ItemChecker(server).runTaskTimer(NeoMinecraftism.getInstance(), 0, 10);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRightClick(PlayerInteractEvent event) {
		ItemStack stack = event.getItem();
		if(NBTHelper.isItemDisabled(stack)) {
			NBTHelper.getTag(stack, "item_id", PersistentDataType.STRING).ifPresent(item_name->{
				RPGItem item = ItemHelper.getItem(item_name);
				int cooldown = item.onRightClick(event.getPlayer());
				NBTHelper.disableItem(stack);
				Bukkit.getScheduler().runTaskLater(NeoMinecraftism.getInstance(), () -> {
					NBTHelper.enableItem(stack);
				}, cooldown);
			});
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemConsume(PlayerItemConsumeEvent event) {
		ItemStack stack = event.getItem();
		NBTHelper.getTag(stack, "item_id", PersistentDataType.STRING).ifPresent(item_name->{
			RPGItem item = ItemHelper.getItem(item_name);
			item.onConsumed(event.getPlayer());
		});
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		ItemStack stack = event.getPlayer().getItemInHand();
		NBTHelper.getTag(stack, "item_id", PersistentDataType.STRING).ifPresent(item_name->{
			RPGItem item = ItemHelper.getItem(item_name);
			item.onEnterSneak(event.getPlayer());
		});
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemSprint(PlayerToggleSprintEvent event) {
		ItemStack stack = event.getPlayer().getItemInHand();
		NBTHelper.getTag(stack, "item_id", PersistentDataType.STRING).ifPresent(item_name->{
			RPGItem item = ItemHelper.getItem(item_name);
			item.onEnterSprint(event.getPlayer());
		});
	}
	
	
	static class ItemChecker extends BukkitRunnable{
		private Server server;
		public ItemChecker(Server server) {
			this.server = server;
		}
		
		
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			if (server==null) {
				this.cancel();
			}
			Collection<? extends Player> players = server.getOnlinePlayers();
			for(Player player :players) {
				ItemStack stack = player.getItemInHand();
				NBTHelper.getTag(stack, "item_id", PersistentDataType.STRING).ifPresent(item_name->{
					RPGItem item = ItemHelper.getItem(item_name);
					item.perHalfSecond(player);
				});
			}	
		}
		
	}

	
}
