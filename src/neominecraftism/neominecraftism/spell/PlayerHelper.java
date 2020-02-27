package neominecraftism.neominecraftism.spell;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.storage.StorageTracker;

public class PlayerHelper {
	
	
	public static double getIntellect(Player player) {
		double base = StorageTracker.getPlayerStorage(player).base_intellect;
		base = ItemHelper.getItem(player.getInventory().getItemInMainHand()).onGetIntellect(player, base, EquipmentSlot.HAND);
		base = ItemHelper.getItem(player.getInventory().getItemInOffHand()).onGetIntellect(player, base,  EquipmentSlot.OFF_HAND);
		base = ItemHelper.getItem(player.getInventory().getChestplate()).onGetIntellect(player, base, EquipmentSlot.CHEST);
		base = ItemHelper.getItem(player.getInventory().getBoots()).onGetIntellect(player, base, EquipmentSlot.FEET);
		base = ItemHelper.getItem(player.getInventory().getHelmet()).onGetIntellect(player, base, EquipmentSlot.HEAD);
		base = ItemHelper.getItem(player.getInventory().getLeggings()).onGetIntellect(player, base, EquipmentSlot.LEGS);
		List<IProfession> professions = ProfessionHelper.getProfessions(player);
		for(IProfession p: professions) {
			base = p.onGetIntellect(player, base);
		}
		return base;
	}
	
	public static double getStrength(Player player) {
		double base = StorageTracker.getPlayerStorage(player).base_strength;
		base = ItemHelper.getItem(player.getInventory().getItemInMainHand()).onGetStrength(player, base, EquipmentSlot.HAND);
		base = ItemHelper.getItem(player.getInventory().getItemInOffHand()).onGetStrength(player, base,  EquipmentSlot.OFF_HAND);
		base = ItemHelper.getItem(player.getInventory().getChestplate()).onGetStrength(player, base, EquipmentSlot.CHEST);
		base = ItemHelper.getItem(player.getInventory().getBoots()).onGetStrength(player, base, EquipmentSlot.FEET);
		base = ItemHelper.getItem(player.getInventory().getHelmet()).onGetStrength(player, base, EquipmentSlot.HEAD);
		base = ItemHelper.getItem(player.getInventory().getLeggings()).onGetStrength(player, base, EquipmentSlot.LEGS);
		List<IProfession> professions = ProfessionHelper.getProfessions(player);
		for(IProfession p: professions) {
			base = p.onGetStrength(player, base);
		}
		return base;
	}
	
	public static void causeMagicDamage(Player player, LivingEntity target, double amount, ISpell spell) {
		RPGItem main = ItemHelper.getItem(player.getInventory().getItemInMainHand());
		RPGItem off = ItemHelper.getItem(player.getInventory().getItemInOffHand());
		amount = main.onCauseMagicDamage(player, amount, spell);
		amount = off.onCauseMagicDamage(player, amount, spell);
		List<IProfession> professions = ProfessionHelper.getProfessions(player);
		for(IProfession p: professions) {
			amount = p.onCauseMagicDamage(player, amount, spell);
		}
		target.damage(amount, player);	
	}
}
