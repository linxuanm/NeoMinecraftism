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

public class Knight extends IProfession {

	public Knight() {
		super("knight");
	}

	@Override
	public String getProfessionName() {
		return "骑士";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"精通所有近战武器和盾牌，但是无法装备轻甲和帽子","被动：持盾时不再受到减速惩罚"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return new WeaponType[] {WeaponType.AXE,WeaponType.HALBERD,WeaponType.SWORD,WeaponType.SHELD};
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.LEGGINGS,EquipmentType.HELMET,EquipmentType.HEAVY_CHESTPLATES};
	}

}
