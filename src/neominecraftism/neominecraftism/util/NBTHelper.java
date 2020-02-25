package neominecraftism.neominecraftism.util;

import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class NBTHelper {
	
	/**
	 * Makes the ItemStack not stackable.
	 */
	public static void makeUnique(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(namespace("unique_id"), PersistentDataType.STRING, UUID.randomUUID().toString());
		stack.setItemMeta(meta);
	}
	
	public static NamespacedKey namespace(String name) {
		return new NamespacedKey(NeoMinecraftism.getInstance(), name);
	}
}
