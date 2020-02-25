package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.profession.IProfession;

public class Civilian extends IProfession {

	public Civilian() {
		super("civilian");
	}

	@Override
	public String getProfessionName() {
		return "平民";
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public Material[] getMasterWeapon() {
		return null;
	}

	@Override
	public Material[] getMasterArmor() {
		return null;
	}
}
