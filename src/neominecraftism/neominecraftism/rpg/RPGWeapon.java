package neominecraftism.neominecraftism.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;

import com.google.common.collect.Multimap;

import neominecraftism.neominecraftism.util.ItemRarity;

public class RPGWeapon extends RPGItem {

	private int level;
	private WeaponType weapon_type;
	public RPGWeapon(String register_name, String display_name, Material material, WeaponType type, ItemRarity rarity, int level) {
		super(register_name, display_name, material, ItemType.WEAPON, rarity);
		this.level = level;
		this.weapon_type=type;
	}
	
	@Override
	public RPGItem withDescription(String... lore) {
		List<String> strings= new ArrayList<String>();
		strings.add(0, weapon_type.getDisplayText());
		if(lore!=null) {
			for(String s:lore) {
				strings.add(s);
			}
		}
		this.getItemStack().getItemMeta().setLore(strings);
		return this;
	}
	
	
	public RPGWeapon withAttributeModifiers(AttributeEntry... attributes) {
		this.getItemStack().getItemMeta().removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
		this.getItemStack().getItemMeta().removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
		for (AttributeEntry entry: attributes) {
			this.getItemStack().getItemMeta().addAttributeModifier(entry.getAttribute(), entry.getAttributeModifier());
		}
		return this;
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
