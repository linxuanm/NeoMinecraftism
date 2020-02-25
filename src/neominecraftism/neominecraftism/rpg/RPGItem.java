package neominecraftism.neominecraftism.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import neominecraftism.neominecraftism.registry.IRegistryEntry;
import neominecraftism.neominecraftism.util.ItemRarity;

public class RPGItem extends IRegistryEntry<RPGItem> {
	private ItemRarity rarity;
	private ItemStack itemstack;
	private ItemType itemtype;
	public RPGItem(String register_name, String display_name, Material material, ItemType type,ItemRarity rarity) {
		super(register_name);
		this.itemstack = new ItemStack(material);
		itemstack.getItemMeta().setDisplayName(rarity.getColor()+display_name);
		this.rarity = rarity;
		this.itemtype=type;
	}
	
	public RPGItem withDescription(String... lore) {
		List<String> strings= new ArrayList<String>();
		strings.add(0, this.itemtype.getDisplayText());
		if(lore!=null) {
			for(String s:lore) {
				strings.add(s);
			}
		}
		this.itemstack.getItemMeta().setLore(strings);
		return this;
	}
	
	public ItemType getItemType() {
		return itemtype;
	}
	public ItemRarity getItemRarity() {
		return rarity;
	}
	public ItemStack getItemStack() {
		return itemstack;
	}
	/**
	 * return a COPY of the itemstack of this rpg_item with the amount
	 * @param amount
	 * @return
	 */
	public ItemStack getItemStack(int amount) {
		ItemStack stack = itemstack.clone();
		stack.setAmount(amount);
		return stack;
	}
	
}
