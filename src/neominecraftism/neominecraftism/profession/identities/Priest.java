package neominecraftism.neominecraftism.profession.identities;

import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
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
import neominecraftism.neominecraftism.util.WorldHelper;

public class Priest extends IProfession {

	public Priest() {
		super("priest");
	}

	@Override
	public String getProfessionName() {
		return "牧师";
	}
	
	@Override
	public String[] getDescription() {
		String[] strings = {"精通法杖，可以给队友施加增益效果。但通常极其依赖队友的伤害","无法装备重甲和帽子","被动：标记周围玩家，略微增加法力值回复速度；周围玩家越多，法力回复越快"};
		return strings;
	}

	@Override
	public boolean upgradeToThis(Player player) {
		return false;
	}

	@Override
	public WeaponType[] getMasterWeapon() {
		return new WeaponType[] {WeaponType.WAND};
	}

	@Override
	public EquipmentType[] getMasterArmor() {
		return new EquipmentType[] {EquipmentType.BOOTS,EquipmentType.HAT,EquipmentType.LEGGINGS,EquipmentType.LIGHT_CHESTPLATES,EquipmentType.HELMET,EquipmentType.HEAVY_CHESTPLATES};
	}
	
	@Override
	public double onGainMana(Player player, double mana_add) {
		Collection<Entity> entities = WorldHelper.getNearbyEntities(player.getLocation(), 5 ,entity-> entity instanceof Player);
		entities.forEach(entity->{
			if(!((Player)entity).getUniqueId().equals(player.getUniqueId()) && !((Player)entity).hasPotionEffect(PotionEffectType.INVISIBILITY)) {
				((Player)entity).addPotionEffect(PotionEffectBuilder.buildIconOnly(PotionEffectType.GLOWING, 30, 0),true);
			}
		});
		mana_add+=0.1*(entities.size()-1);
		return mana_add;
	}

}
