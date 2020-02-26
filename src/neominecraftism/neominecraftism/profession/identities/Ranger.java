package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;

public class Ranger extends IProfession {

	public Ranger() {
		super("ranger");
	}

	@Override
	public String getProfessionName() {
		return "游侠";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"精通弓箭和弩，但是不能装备重甲和头盔","被动：每五秒获得一支箭"};

		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return new WeaponType[] {WeaponType.BOW,WeaponType.CROSS_BOW};
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.HAT,EquipmentType.LEGGINGS,EquipmentType.LIGHT_CHESTPLATES};
	}
	
	@Override
	public void effectPerFiveSecond(Player player) {
		player.getInventory().addItem(new ItemStack(Material.ARROW));
	}

}
