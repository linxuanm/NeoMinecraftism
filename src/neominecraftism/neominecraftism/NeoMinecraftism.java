package neominecraftism.neominecraftism;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import neominecraftism.neominecraftism.command.CommandHandler;
import neominecraftism.neominecraftism.registry.Registries;
import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.rpg.RPGHandler;
import neominecraftism.neominecraftism.rpg.items.ItemHelper;
import neominecraftism.neominecraftism.storage.StorageTracker;
import neominecraftism.neominecraftism.subscriber.ProfessionHandler;
import neominecraftism.neominecraftism.subscriber.SpellHandler;
import neominecraftism.neominecraftism.subscriber.WorldHandler;

public class NeoMinecraftism extends JavaPlugin {
	
	private static NeoMinecraftism instance;
	private RegistryHandler registryHandler;
	private StorageTracker storageTracker;
	
	public static NeoMinecraftism getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		this.registryHandler = new RegistryHandler();
		this.populateRegistries();
		
		this.storageTracker = new StorageTracker();
				
		this.getServer().getPluginManager().registerEvents(new SpellHandler(), this);
		this.getServer().getPluginManager().registerEvents(new ProfessionHandler(), this);
		this.getServer().getPluginManager().registerEvents(new WorldHandler(), this);
		this.getServer().getPluginManager().registerEvents(new RPGHandler(), this);

		ProfessionHandler.init(getServer());
		CommandHandler.init();
	}
	
//	@Override
//	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//		
//		if(command.getName().equalsIgnoreCase("rpgitem")) {
//			if(sender instanceof Player) {
//				((Player) sender).getInventory().addItem(ItemHelper.getItem(args[0]).build());
//			}
//			return true;
//		}
//		return super.onCommand(sender, command, label, args);
//	}
	
	@Override
	public void onDisable() {
		this.storageTracker.dumpAll();
	}
	
	
	public RegistryHandler getRegistryHandler() {
		return this.registryHandler;
	}
	
	
	public StorageTracker getStorageTracker() {
		return this.storageTracker;
	}
	
	private void populateRegistries() {
		Registries.registerSpells(registryHandler);
		Registries.registerMenus(registryHandler);
		Registries.registerProfession(registryHandler);
		Registries.registerItem(registryHandler);

	}
}
