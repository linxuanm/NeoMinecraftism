package neominecraftism.neominecraftism.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegistryHandler {
	
	private Map<Class<? extends IRegistryEntry<?>>, RegistryType> registries;
	
	public RegistryHandler() {
		this.registries = new HashMap<>();
	}
	
	public void addRegistryType(Class<? extends IRegistryEntry<?>> clazz) {
		this.registries.put(clazz, new RegistryType());
	}
	
	public void register(Class<? extends IRegistryEntry<?>> clazz, IRegistryEntry<?> entry) {
		this.registries.get(clazz).register(entry);
	}
	
	public <T extends IRegistryEntry<?>> T get(Class<? extends IRegistryEntry<?>> clazz, String name) {
		return this.registries.get(clazz).get(name);
	}
	public <T extends IRegistryEntry<?>> Set<String> getRegistryNames(Class<? extends IRegistryEntry<?>> clazz) {
		return this.registries.get(clazz).getKeySet();
	}
}
