package neominecraftism.neominecraftism.menu;

import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.registry.IRegistryEntry;

public abstract class IClickableMenu extends IRegistryEntry<IClickableMenu> {

	public IClickableMenu(String registryName) {
		super(registryName);
	}
	
	/**
	 * Called when the player clicks on a slot in the inventory representation of this menu.
	 * 
	 * @param player The player.
	 * @param index The index of the slot the player clicked.
	 */
	public abstract void onClickSlot(Player player, int index);
}
