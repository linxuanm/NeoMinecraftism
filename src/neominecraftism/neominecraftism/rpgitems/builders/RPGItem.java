package neominecraftism.neominecraftism.rpgitems.builders;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.registry.IRegistryEntry;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper.EnchantmentEntry;
import neominecraftism.neominecraftism.spell.ISpell;
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
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
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
	/**
	 * behave when player right click on block/air
	 * @param player player that hold the item
	 * @return return the time for the cool down of the usage (in ticks).
	 */
	public int onRightClick(Player player) {return 0;}
	
	/**
	 * behave when player finish using the item
	 * for example finish eating/drinking
	 * 
	 * @param player player that hold the item
	 */
	public void onConsumed(Player player) {}
	
	/**
	 * behave when player toggle into sneak state
	 * @param player player that hold the item
	 */
	public void onEnterSneak(Player player) {}
	
	/**
	 * behave when player toggle into sprint state
	 * @param player player that hold the item
	 */
	public void onEnterSprint(Player player) {}
	
	/**
	 * behave per half second (10ticks)
	 * @param player player that hold the item
	 */
	public void perHalfSecond(Player player) {}
	
	public double onGainMana(Player player, double mana_add, boolean is_mainhand) {
		return mana_add;
	}
	public double onGetIntellect(Player player, double intellect, EquipmentSlot slot) {
		return intellect;
	}
	public double onGetStrength(Player player, double strength, EquipmentSlot slot) {
		return strength;
	}
	public double onCauseMagicDamage(Player player, double amount, ISpell spell) {
		return amount;
	}
}
