package neominecraftism.neominecraftism.spell;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;

import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.rpgitems.builders.RPGMeleeWeapon;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;
import neominecraftism.neominecraftism.spell.caster.MassHealingSpell;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper.AttributeEntry;
import neominecraftism.neominecraftism.util.ItemRarity;

public class SpellRegistry {

	public static void register(RegistryHandler handler) {
		handler.register(ISpell.class, new MassHealingSpell());
	}
}
