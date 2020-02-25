package neominecraftism.neominecraftism.subscriber;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;

public class ProfessionHandler implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		if(!event.getPlayer().getPersistentDataContainer().has(ProfessionHelper.IDENTITY, ProfessionHelper.STRING_ARRAY)) {
			List<IProfession> list= new ArrayList<IProfession>();
			ProfessionHelper.setProfessions(event.getPlayer(), list);
		}
		new ProfessionEffect(event.getPlayer()).runTaskTimer(NeoMinecraftism.getInstance(), 0, 10);
	}
	/**
	 * a runnable that is scheduled for every 10 tick
	 */
	class ProfessionEffect extends BukkitRunnable{
		private Player player;
		private int count;
		public ProfessionEffect(Player player) {
			this.player = player;
		}
		@Override
		public void run() {
			if (player==null || !player.isValid()) {
				this.cancel();
			}
			count++;
			List<IProfession> professions = ProfessionHelper.getProfessions(player);
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
