package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import neominecraftism.neominecraftism.profession.IProfession;

public class Ranger extends IProfession {

	public Ranger() {
		super("ranger");
	}

	@Override
	public String getProfessionName() {
		return "游侠";
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
	
	@Override
	public void effectPerFiveSecond(Player player) {
		player.getInventory().addItem(new ItemStack(Material.ARROW));
	}

}
