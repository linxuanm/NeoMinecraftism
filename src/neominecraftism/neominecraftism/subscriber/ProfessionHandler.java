package neominecraftism.neominecraftism.subscriber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;

public class ProfessionHandler implements Listener {

	public static void init(Server server) {
		new ProfessionRunnable(server).runTaskTimer(NeoMinecraftism.getInstance(), 0, 10);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		List<IProfession> professions = ProfessionHelper.getProfessions(event.getPlayer());
		if(professions.size()==0) {
			ProfessionHelper.addProfession(event.getPlayer(), ProfessionHelper.getProfession("civilian"));
		}
	}
	/**
	 * a runnable that is scheduled for every 10 tick
	 */
	static class ProfessionRunnable extends BukkitRunnable{
		private Server server;
		private int count;
		public ProfessionRunnable(Server server) {
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
				
			}	
		}
		
	}

}
