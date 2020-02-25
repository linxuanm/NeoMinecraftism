package neominecraftism.neominecraftism;

import org.bukkit.plugin.java.JavaPlugin;

import neominecraftism.neominecraftism.registry.Registries;
import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.subscriber.SpellHandler;

public class NeoMinecraftism extends JavaPlugin {
	
	private static NeoMinecraftism instance;
	private RegistryHandler registryHandler;
	
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
				
		this.getServer().getPluginManager().registerEvents(new SpellHandler(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
	public RegistryHandler getRegistryHandler() {
		return this.registryHandler;
	}
	
	private void populateRegistries() {
		Registries.registerSpells(registryHandler);
		Registries.registerMenus(registryHandler);
		Registries.registerProfession(registryHandler);
	}
}
