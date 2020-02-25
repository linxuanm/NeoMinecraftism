package neominecraftism.neominecraftism.registry;

/**
 * A registry object.
 * 
 * @author David Ma
 *
 * @param <T> The class type inherits this.
 */
public abstract class IRegistryEntry<T extends IRegistryEntry<T>> {
	
	private String registryName;
	
	public IRegistryEntry(String registryName) {
		this.registryName = registryName;
	}
	
	public String getRegistryName() {
		return this.registryName;
	}
	
	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}
}
