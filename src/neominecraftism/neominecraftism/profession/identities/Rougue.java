package neominecraftism.neominecraftism.profession.identities;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;
import neominecraftism.neominecraftism.storage.StorageTracker;
import neominecraftism.neominecraftism.util.PotionEffectBuilder;

public class Rougue extends IProfession {

	public Rougue() {
		super("rougue");
	}

	@Override
	public String getProfessionName() {
		return "潜行者";
	}
	@Override
	public String[] getDescription() {
		String[] strings = {"精通剑和弩，但是不能装备重甲和头盔","被动：潜行5秒后获得持续的隐身，直到攻击为止"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return new WeaponType[] {WeaponType.SWORD,WeaponType.CROSS_BOW};
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.HAT,EquipmentType.LEGGINGS,EquipmentType.LIGHT_CHESTPLATES};
	}
	
	@Override
	public void effectPerHalfSecond(Player player) {
		if(player.isSneaking()) {
			StorageTracker.getPlayerStorage(player).stealth_timer+=1;
			if(StorageTracker.getPlayerStorage(player).stealth_timer>10) {
				player.addPotionEffect(PotionEffectBuilder.buildIconOnly(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0),true);
				StorageTracker.getPlayerStorage(player).stealth_timer=0;
			}
		}else {
			StorageTracker.getPlayerStorage(player).stealth_timer=0;
		}
	}
	@Override
	public double onAttack(Player player, Entity target, DamageCause cause, double raw_damage) {
		if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		return raw_damage;
	}

}
