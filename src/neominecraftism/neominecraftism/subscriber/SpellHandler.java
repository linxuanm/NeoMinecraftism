package neominecraftism.neominecraftism.subscriber;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.ManaHelper;
import neominecraftism.neominecraftism.spell.SpellHelper;
import neominecraftism.neominecraftism.spell.caster.NextAttackSpell;
import neominecraftism.neominecraftism.storage.StorageTracker;
import neominecraftism.neominecraftism.subscriber.RPGItemHandler.ItemChecker;
import neominecraftism.neominecraftism.util.NBTHelper;

public class SpellHandler implements Listener {
	
	public static void init(Server server) {
		new ManaProducer(server).runTaskTimer(NeoMinecraftism.getInstance(), 0, 20);
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRightClick(PlayerInteractEvent event) {
		if (!event.hasItem()) return;
		
		ItemStack stack = event.getItem();
		if(stack!=null && stack.getType()!=Material.AIR) {
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
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerAttack(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if(StorageTracker.getPlayerStorage(player).spell_tags.size()>0) {
				for(String name:StorageTracker.getPlayerStorage(player).spell_tags) {
					SpellHelper.getSpell(name).ifPresent(spell->{
						if(spell instanceof NextAttackSpell) {
							double damage = ((NextAttackSpell)spell).onNextAttack(player, event.getEntity(),event.getDamage());
							event.setDamage(damage);
						}
					});
				}
			}
		}
	}
	
		
	static class ManaProducer extends BukkitRunnable{
		private Server server;
		public ManaProducer(Server server) {
			this.server = server;
		}
		
		@Override
		public void run() {
			if (server==null) {
				this.cancel();
			}
			Collection<? extends Player> players = server.getOnlinePlayers();
			for(Player player :players) {
				double mana_reg_speed = 1;
				for(IProfession profession: ProfessionHelper.getProfessions(player)) {
					mana_reg_speed = profession.onGainMana(player, mana_reg_speed);
				}
				mana_reg_speed = ItemHelper.getItem(player.getInventory().getItemInMainHand()).onGainMana(player, mana_reg_speed,true);
				mana_reg_speed = ItemHelper.getItem(player.getInventory().getItemInOffHand()).onGainMana(player, mana_reg_speed,true);
				ManaHelper.addMana(player, mana_reg_speed);
				
			}	
		}
		
	}
}
