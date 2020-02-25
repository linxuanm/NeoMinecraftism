package neominecraftism.neominecraftism.menu.builder;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Sets the property of an inventory. This is a facet of {@link MenuBuilder}.
 * 
 * @author David Ma
 */
public class MenuProperty {
	
	private MenuBuilder parent;
	private String name;
	private int slotAmount;
	
	public MenuProperty(MenuBuilder parent) {
		this.parent = parent;
	}
	
	public MenuProperty withName(String name) {
		this.name = name;
		
		return this;
	}
	
	public MenuProperty withSlotAmount(int slotAmount) {
		this.slotAmount = slotAmount;
		
		return this;
	}
	
	public MenuBuilder withInventory() {
		return this.parent;
	}
	
	/**
	 * Instantiate an inventory that can be opened to the player.
	 * 
	 * @return The created inventory.
	 */
	public Inventory createInventory() {
		return Bukkit.createInventory(null, this.slotAmount, this.name);
	}
}
