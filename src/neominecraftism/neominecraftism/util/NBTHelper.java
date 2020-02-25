package neominecraftism.neominecraftism.util;

import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class NBTHelper {
	
	/**
	 * Makes the ItemStack not stackable.
	 */
	public static void makeUnique(ItemStack stack) {
		getTag(stack).set(namespace("unique_id"), PersistentDataType.STRING, UUID.randomUUID().toString());
	}
	
	public static PersistentDataContainer getTag(ItemStack stack) {
		return stack.getItemMeta().getPersistentDataContainer();
	}
	
	public static NamespacedKey namespace(String name) {
		return new NamespacedKey(NeoMinecraftism.getInstance(), name);
	}
}
