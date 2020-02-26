package neominecraftism.neominecraftism.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A manager for one type of registry.
 * 
 * @author David Ma
 *
 * @param <T> The type of the managed registry.
 */
public class RegistryType {
	
	private Map<String, IRegistryEntry<?>> entries;
	
	public RegistryType() {
		this.entries = new HashMap<>();
	}
	
	public void register(IRegistryEntry<?> entry) {
		this.entries.put(entry.getRegistryName(), entry);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IRegistryEntry<?>> T get(String name) {
		return (T) this.entries.get(name);
	}
	
	public <T extends IRegistryEntry<?>> Set<String> getKeySet() {
		return this.entries.keySet();
	}
}
