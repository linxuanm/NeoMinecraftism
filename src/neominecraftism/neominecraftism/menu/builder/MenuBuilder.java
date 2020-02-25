package neominecraftism.neominecraftism.menu.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * An instance of this class prepares an inventory. Consumers are used to manipulate 
 * inventories and make it possible to create multiple instances of a menu.
 * 
 * @author David Ma
 */
public class MenuBuilder {
	
	private MenuProperty property;
	private List<Consumer<Inventory>> actions;
	
	public MenuBuilder() {
		this.property = new MenuProperty(this);
		this.actions = new ArrayList<>();
	}
	
	/**
	 * Sets the slot corresponding to the index in the inventory to the given stack.
	 * 
	 * @param index The index that should be overwritten.
	 * @param stack The ItemStack to set to.
	 */
	public MenuBuilder setStack(int index, ItemStack stack) {
		this.actions.add(inv -> inv.setItem(index, stack.clone()));
		
		return this;
	}
	
	/**
	 * Sets the given slot to empty.
	 * 
	 * @param index The index that should be overwritten.
	 */
	public MenuBuilder clearSlot(int index) {
		this.actions.add(inv -> inv.clear(index));
		
		return this;
	}
	
	/**
	 * Fills the given range with the given ItemStack.
	 * 
	 * @param start The inclusive start of the range.
	 * @param end The exclusive end of the range.
	 * @param stack The ItemStack to set to.
	 */
	public MenuBuilder fillRange(int start, int end, ItemStack stack) {
		this.actions.add(inv -> {
			for (int i = start; i < end; i++) {
				inv.setItem(i, stack.clone());
			}
		});
		
		return this;
	}
	
	/**
	 * Fills all slots with the given stack.
	 * 
	 * @param stack The ItemStack to set to.
	 */
	public MenuBuilder fillAll(ItemStack stack) {
		this.actions.add(inv -> {
			for (int i = 0; i < inv.getSize(); i++) {
				inv.setItem(i, stack.clone());
			}
		});
		
		return this;
	}
	
	public MenuProperty withProperty() {
		return this.property;
	}
	
	/**
	 * Instantiate an inventory that can be opened to the player.
	 * 
	 * @return The created inventory.
	 */
	public Inventory createInventory() {
		Inventory inv = this.property.createInventory();
		this.actions.forEach(action -> action.accept(inv));
		
		return inv;
	}
}
