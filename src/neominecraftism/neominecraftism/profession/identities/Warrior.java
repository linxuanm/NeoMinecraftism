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

public class Warrior extends IProfession {

	public Warrior() {
		super("warrior");
	}

	@Override
	public String getProfessionName() {
		return "战士";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"精通所有近战武器，但是副手无法持有物品","被动：手持精通的武器时额外获得3点伤害提升，副手持有物品时无法攻击"};
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
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.HAT,EquipmentType.LEGGINGS,EquipmentType.LIGHT_CHESTPLATES,EquipmentType.HELMET,EquipmentType.HEAVY_CHESTPLATES};
	}
	
	@Override
	public void effectPerHalfSecond(Player player) {
		ItemStack offhand = player.getInventory().getItemInOffHand();
		if(offhand.equals(null)||offhand.getType().equals(Material.AIR)) {
			RPGItem item = ItemHelper.getItem(player.getInventory().getItemInMainHand());
			if (item!=null && item instanceof RPGMeleeWeapon) {
				if(player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
					int lvl = player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier();
					player.addPotionEffect(PotionEffectBuilder.buildHidden(PotionEffectType.INCREASE_DAMAGE, 20, lvl+1),true);
				}else {
					player.addPotionEffect(PotionEffectBuilder.buildHidden(PotionEffectType.INCREASE_DAMAGE, 20, 0),true);
				}
			}
		} else {
			player.addPotionEffect(PotionEffectBuilder.buildHidden(PotionEffectType.WEAKNESS, 20, 10),true);
		}
		super.effectPerHalfSecond(player);
	}

}
