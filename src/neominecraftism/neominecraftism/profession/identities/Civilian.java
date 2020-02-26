package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;

public class Civilian extends IProfession {

	public Civilian() {
		super("civilian");
	}

	@Override
	public String getProfessionName() {
		return "平民";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"城镇的普通居民"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return null;
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return null;
	}

	
}
