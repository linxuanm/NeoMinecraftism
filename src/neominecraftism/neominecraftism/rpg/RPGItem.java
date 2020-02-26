package neominecraftism.neominecraftism.rpg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.registry.IRegistryEntry;
import neominecraftism.neominecraftism.util.ItemRarity;
import neominecraftism.neominecraftism.util.NBTHelper;

public class RPGItem extends IRegistryEntry<RPGItem> {
	protected ItemRarity rarity;
	protected ItemType itemtype;
	protected String[] lore;
	protected Material material;
	protected String register_name;
	protected String display_name;
	protected List<EnchantmentEntry> enchantments = new ArrayList<EnchantmentEntry>();
	public RPGItem(String register_name, String display_name, Material material, ItemType type,ItemRarity rarity) {
		super(register_name);
		this.rarity = rarity;
		this.itemtype=type;
		this.material = material;
		this.display_name = display_name;
	}
	
	public RPGItem withDescription(String... lore) {
		this.lore = lore;	
		return this;
	}
	public RPGItem withEnchantment(EnchantmentEntry enchantment) {
		this.enchantments.add(enchantment);
		return this;
	}
	
	public ItemStack build() {
		ItemStack itemstack = new ItemStack(this.material);
		ItemMeta meta = itemstack.getItemMeta();
		//set display
		meta.setDisplayName(this.rarity.getColor()+this.display_name);
		//set lore
		List<String> strings= new ArrayList<String>();
		strings.add(0, ChatColor.ITALIC+this.itemtype.getDisplayText());
		if(this.lore!=null) {
			for(String s:this.lore) {
				strings.add(s);
			}
		}
		meta.setLore(strings);
		//set enchantment
		for(EnchantmentEntry enchant: enchantments) {
			meta.addEnchant(enchant.getEnchantment(), enchant.getLvl(), true);
		}
//		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.getPersistentDataContainer().set(NBTHelper.namespace("item_id"), PersistentDataType.STRING, this.getRegistryName());
		
		itemstack.setItemMeta(meta);
		return itemstack;
	}
	
	
	public ItemType getItemType() {
		return itemtype;
	}
	public ItemRarity getItemRarity() {
		return rarity;
	}
	/**
	 * return a COPY of the itemstack of this rpg_item with the amount
	 * @param amount
	 * @return
	 */
	public ItemStack Build(int amount) {
		ItemStack stack = this.build();
		stack.setAmount(amount);
		return stack;
	}
	
	public static class EnchantmentEntry {
		private Enchantment enchantment;
		private int lvl;
		public EnchantmentEntry(Enchantment enchantment, int lvl) {
			this.enchantment = enchantment;
			this.lvl = lvl;
		}
		
		public Enchantment getEnchantment() {
			return enchantment;
		}

		public void setEnchantment(Enchantment enchantment) {
			this.enchantment = enchantment;
		}

		public int getLvl() {
			return lvl;
		}

		public void setLvl(int lvl) {
			this.lvl = lvl;
		}


	}
	
}
