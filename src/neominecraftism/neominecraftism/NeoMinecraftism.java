package neominecraftism.neominecraftism;

import org.bukkit.plugin.java.JavaPlugin;

import neominecraftism.neominecraftism.registry.Registries;
import neominecraftism.neominecraftism.registry.RegistryHandler;
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
	}
	
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
	}
}
