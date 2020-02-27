package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.rpgitems.builders.RPGMeleeWeapon;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;
import neominecraftism.neominecraftism.util.PotionEffectBuilder;

public class Mage extends IProfession {

	public Mage() {
		super("mage");
	}

	@Override
	public String getProfessionName() {
		return "法师";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"精通法杖，但通常极其依赖法术的伤害，无法装备重甲和头盔","被动：副手持法杖时略微增加法力值回复速度"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return new WeaponType[] {WeaponType.AXE,WeaponType.HALBERD,WeaponType.SWORD};
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.HAT,EquipmentType.LEGGINGS,EquipmentType.LIGHT_CHESTPLATES};
	}
	
	@Override
	public double onGainMana(Player player, double mana_add) {
		RPGItem item = ItemHelper.getItem(player.getInventory().getItemInOffHand());
		if (item instanceof RPGMeleeWeapon && ((RPGMeleeWeapon)item).getWeaponType().equals(WeaponType.WAND)) {
			mana_add+=0.5;
		}
		return mana_add;
	}

}
