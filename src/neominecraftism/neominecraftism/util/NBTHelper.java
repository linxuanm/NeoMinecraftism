package neominecraftism.neominecraftism.util;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.sun.istack.internal.NotNull;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class NBTHelper {
		
	/**
	 * Makes the ItemStack not stackable.
	 */
	public static void makeUnique(ItemStack stack) {
		setTag(stack, "unique_id", PersistentDataType.STRING, UUID.randomUUID().toString());
	}
	
	public static boolean isItemDisabled(ItemStack stack) {
		Optional<Integer> optional = getTag(stack, "disabled", PersistentDataType.INTEGER);
		return optional.isPresent() && optional.get() == 1;
	}
	
	public static void disableItem(ItemStack stack) {
		setTag(stack, "disabled", PersistentDataType.INTEGER, 1);
	}
	
	public static void enableItem(ItemStack stack) {
		setTag(stack, "disabled", PersistentDataType.INTEGER, 0);
	}
	
	public static <T> Optional<T> getTag(@NotNull ItemStack stack, String name, PersistentDataType<?, T> type) {
		return getTag(stack, namespace(name), type);
	}
	
	 
	public static <T> Optional<T> getTag(@NotNull ItemStack stack, NamespacedKey id, PersistentDataType<?, T> type) {
		return Optional.ofNullable(stack.getItemMeta().getPersistentDataContainer().get(id, type));
	}
	
	public static <T> void setTag(ItemStack stack, String name, PersistentDataType<?, T> type, T value) {
		ItemMeta meta = stack.getItemMeta();
		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(namespace(name), type, value);
		stack.setItemMeta(meta);
	}
	
	public static boolean hasTag(ItemStack stack, String name, PersistentDataType<?, ?> type) {
		return hasTag(stack, namespace(name), type);
	}
	
	public static boolean hasTag(ItemStack stack, NamespacedKey id, PersistentDataType<?, ?> type) {
		return stack.getItemMeta().getPersistentDataContainer().has(id, type);
	}
	
	public static NamespacedKey namespace(String name) {
		return new NamespacedKey(NeoMinecraftism.getInstance(), name);
	}
}
