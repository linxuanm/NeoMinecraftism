package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;

public class Noble extends IProfession {

	public Noble() {
		super("noble");
	}

	@Override
	public String getProfessionName() {
		return "贵族";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"比平民更有权力的身份，能够出入一些特殊场景"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		if(ProfessionHelper.hasProfession(player, "civilian")) {
			ProfessionHelper.addProfession(player, ProfessionHelper.getProfession("noble"));
			return true;
		}
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
