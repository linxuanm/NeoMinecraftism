package neominecraftism.neominecraftism.rpgitems;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.rpgitems.builders.RPGMeleeWeapon;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper.AttributeEntry;
import neominecraftism.neominecraftism.util.ItemRarity;

public class WeaponRegistry {
	
	public static void register(RegistryHandler handler) {
		handler.register(RPGItem.class, new RPGMeleeWeapon("base_axe","原石斧", Material.STONE_AXE, WeaponType.AXE, ItemRarity.NORMAL, 1)
				.withAttackDamageAndSpeed(9, 1.1)
				.withOtherAttribute(new AttributeEntry(Attribute.GENERIC_ARMOR, EquipmentSlot.HAND, 2, Operation.ADD_NUMBER))
				.withDescription("原石制作的斧子，略微增加一些护甲"));
	}
}
