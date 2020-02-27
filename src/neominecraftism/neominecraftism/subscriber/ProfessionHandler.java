package neominecraftism.neominecraftism.subscriber;

import java.util.Collection;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.spell.PlayerHelper;
import neominecraftism.neominecraftism.storage.StorageTracker;
import neominecraftism.neominecraftism.util.PotionEffectBuilder;

public class ProfessionHandler implements Listener {

	public static void init(Server server) {
		new ProfessionChecker(server).runTaskTimer(NeoMinecraftism.getInstance(), 0, 10);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		List<IProfession> professions = ProfessionHelper.getProfessions(event.getPlayer());
		if(professions.size()==0) {
			ProfessionHelper.addProfession(event.getPlayer(), ProfessionHelper.getProfession("civilian"));
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerAttack(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player player = (Player)event.getDamager();
			double damage = event.getDamage();
			List<IProfession> professions = ProfessionHelper.getProfessions(player);
			if(professions.size()>0) {
				for(IProfession profession: professions) {
					damage = profession.onAttack(player, event.getEntity(), event.getCause(), damage);
				}
			}
			damage += PlayerHelper.getStrength(player);
			event.setDamage(damage);
			
		} else if (event.getEntity() instanceof Player) {
			Player player = (Player)event.getEntity();
			List<IProfession> professions = ProfessionHelper.getProfessions(player);
			if(professions.size()>0) {
				for(IProfession profession: professions) {
					event.setDamage(profession.beingAttacked(player, event.getDamager(), event.getCause(), event.getDamage()));
				}
			}
		}
	}
	
	/**
	 * a runnable that is scheduled for every 10 tick
	 */
	static class ProfessionChecker extends BukkitRunnable{
		private Server server;
		private int count;
		public ProfessionChecker(Server server) {
			this.server = server;
		}
		@Override
		public void run() {
			if (server==null) {
				this.cancel();
			}
			
			count++;
			Collection<? extends Player> players = server.getOnlinePlayers();
			for(Player player :players) {
				List<IProfession> professions = ProfessionHelper.getProfessions(player);
				if(professions.size()>0) {
					for(IProfession profession: professions) {
						profession.effectPerHalfSecond(player);
						if (count%10 == 0) {
							profession.effectPerFiveSecond(player);
						}
						if (count%20 == 0) {
							profession.effectPerTenSecond(player);
						}
					}
				}
				//checker
				if (player.getInventory().getItemInOffHand().getType().equals(Material.SHIELD) && !ProfessionHelper.hasProfession(player, "knight")) {
					player.addPotionEffect(PotionEffectBuilder.buildIconOnly(PotionEffectType.SLOW, 20, 1),true);
				}
				
			}	
		}
		
	}

}
