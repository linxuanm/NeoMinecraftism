package neominecraftism.neominecraftism.rpg.items;

import java.util.UUID;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class ItemHelper {
	
	public static RPGItem getItem(String item_id) {
		return NeoMinecraftism.getInstance().getRegistryHandler().get(RPGItem.class, item_id);
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
	public static class AttributeEntry {
		private Attribute attribute;
		private AttributeModifier attribute_modifier;
		
		public AttributeEntry(Attribute attribute, EquipmentSlot slot, double amount, Operation operation) {
			this.attribute = attribute;
			this.attribute_modifier  = new AttributeModifier(
					UUID.randomUUID(),
					attribute.name(), 
					amount, 
					operation,
					slot);
		}

		public Attribute getAttribute() {
			return attribute;
		}

		public void setAttribute(Attribute attribute) {
			this.attribute = attribute;
		}

		public AttributeModifier getAttributeModifier() {
			return attribute_modifier;
		}

		public void setAttributeModifier(AttributeModifier attribute_modifier) {
			this.attribute_modifier = attribute_modifier;
		}	
	}
}
