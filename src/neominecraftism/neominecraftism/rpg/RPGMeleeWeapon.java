package neominecraftism.neominecraftism.rpg;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import neominecraftism.neominecraftism.util.ItemRarity;

public class RPGMeleeWeapon extends RPGItem {

	private DecimalFormat format= new DecimalFormat("0.0");
	private int level;
	private WeaponType weapon_type;
	private double damage=1;
	private double attack_speed=0.25;
	private List<AttributeEntry> attributes= new ArrayList<AttributeEntry>();
	public RPGMeleeWeapon(String register_name, String display_name, Material material, WeaponType type, ItemRarity rarity, int level) {
		super(register_name, display_name, material, ItemType.WEAPON, rarity);
		this.level = level;
		this.weapon_type=type;
	}
	
	@Override
	public ItemStack build() {
		ItemStack itemstack = super.build();
		ItemMeta meta = itemstack.getItemMeta();
		//add lore
		List<String> strings= new ArrayList<String>();
		strings.add(ChatColor.ITALIC+String.format("%d级%s", this.level, this.weapon_type.getDisplayText()));
		if(this.lore!=null) {
			for(String s:this.lore) {
				strings.add(ChatColor.ITALIC+s);
			}
		}
		strings.add(ChatColor.YELLOW+String.format("近战伤害: %s", format.format(this.damage)));
		strings.add(ChatColor.YELLOW+String.format("攻击间隔: %s", format.format(this.attack_speed)));

		
		meta.setLore(strings);
		
		//add speed and damage
		double modified_attack_speed = 1/attack_speed-4;
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), Attribute.GENERIC_ATTACK_DAMAGE.name(), damage, Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), Attribute.GENERIC_MOVEMENT_SPEED.name(), modified_attack_speed, Operation.ADD_NUMBER, EquipmentSlot.HAND));
		
		//add others
		attributes.forEach(attribute->meta.addAttributeModifier(attribute.getAttribute(),attribute.getAttributeModifier()));		
		
		itemstack.setItemMeta(meta);
		return itemstack;
	}
	
	/**
	 * set the damage and attack speed to the weapon
	 * 
	 * @param damage the attack damage of the weapon
	 * @param speed attack speed - the cool down time between each use
	 * @return
	 */
	public RPGMeleeWeapon withAttackDamageAndSpeed(double damage, double speed) {
		this.attack_speed =speed;
		this.damage = damage;
		return this;
	}
	public RPGMeleeWeapon withOtherAttribute(AttributeEntry attribute) {
		this.attributes.add(attribute);
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
